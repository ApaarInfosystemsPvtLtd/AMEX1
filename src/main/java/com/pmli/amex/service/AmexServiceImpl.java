package com.pmli.amex.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pmli.amex.constants.Status;
import com.pmli.amex.model.log.*;
import com.pmli.amex.model.request.db.RetailUploadSubmission;
import com.pmli.amex.model.request.filenet.DocumentDTO;
import com.pmli.amex.model.request.illustration.MunichreRequest;
import com.pmli.amex.model.response.NvestPDFResponse;
import com.pmli.amex.model.response.Response;
import com.pmli.amex.model.response.filenet.DocumentUploadResponse;
import com.pmli.amex.repo.AmexApplicationStateRepo;
import com.pmli.amex.repo.AmexDailyApplicationsRepo;
import com.pmli.amex.util.NvestMapper1;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AmexServiceImpl implements AmexService {

    private final Logger logger = LoggerFactory.getLogger(AmexServiceImpl.class);

    @Autowired
    IllustrationService illustrationService;

    @Autowired
    FilenetUploadService filenetUploadService;

    @Autowired
    NvestBiPdfService nvestBiPdfService;

    @Autowired
    NvestMapper1 nvestMapper;

    @Autowired
    AmexApplicationStateRepo amexApplicationStateRepo;

    @Autowired
    AmexDailyApplicationsRepo amexDailyApplicationsRepo;

    @Autowired
    FetchingDBData fetchingDBData;

    public String pushDataToFilenet(List<String> applicationNumberList, String process) {
        logger.info("AmexServiceImpl::pushDataToFilenet::Started::{}", LocalDateTime.now());
        String message = "";
        AmexDailyApplications amexDailyApplications = new AmexDailyApplications();
        amexDailyApplications.setProcessedDate(String.valueOf(LocalDate.now()));
        amexDailyApplications.setProcessedDateTime(LocalDateTime.now());
        amexDailyApplications.setProcessingApplicationList(applicationNumberList);
        amexDailyApplications.setProcessStage(process);
        amexDailyApplicationsRepo.save(amexDailyApplications);

        for (String applicationNumber : applicationNumberList) {
            AmexApplicationState amexApplicationState = new AmexApplicationState();
            Nvest nvest = new Nvest();
            FilenetUpload filenetUpload = new FilenetUpload();
            try {
                amexApplicationState.setApplicationNumber(applicationNumber);
                logger.info("AmexServiceImpl::pushDataToFilenet::Application_Number::{}", applicationNumber);
                MunichreRequest request = nvestMapper.getIllustrationCounterofferParameter(applicationNumber);
                request.setPrChannel("22");
                nvest.setMunichreRequest(new Gson().toJson(request));
                Response response = illustrationService.getIllustrationResponse(request);
                nvest.setIllustrationResponse(new Gson().toJson(response));
                if (response.getIllustrationResponse() != null
                        && "Success".equalsIgnoreCase(response.getIllustrationResponse().getStatus())
                        && response.getIllustrationResponse().getQuotationId()!=null) {
                    nvest.setNvestStatus(Status.SUCCESS.getKey());
                    String pdfData = getBiPdf(response.getIllustrationResponse().getQuotationId(), nvest);
                    if (!"".equalsIgnoreCase(pdfData)) {
                        DocumentDTO documentDTO = getDocumentDetails(pdfData, request.getUniquekey());
                        filenetUpload.setDocumentDTO(documentDTO);
                        DocumentUploadResponse documentUploadResponse = filenetUploadService.documentUpload(documentDTO, filenetUpload);
                        if (!documentUploadResponse.getMessage().equalsIgnoreCase("Document added successfully")) {
                            amexApplicationState.setStatus("FAILED -Document Upload");
                            message = "Document Not added successfully";
                            filenetUpload.setFilenetUploadMessage(message);
                            amexApplicationState.setFilenetUpload(filenetUpload);
                            amexApplicationState.setStatus(Status.FAILURE.getKey());
                        } else {
                            amexApplicationState.setStatus(Status.SUCCESS.getKey());
                            message = "Document added successfully";
                            filenetUpload.setFilenetUploadMessage(message);
                            amexApplicationState.setFilenetUpload(filenetUpload);
                            //Method DB application IS ="Y"
                            updateIsBiGeneratedColumnInDBForApplicationNumber(applicationNumber);
                        }
                        amexApplicationState.setNvest(nvest);
                    } else {
                        amexApplicationState.setNvest(nvest);
                        amexApplicationState.setStatus(Status.FAILURE.getKey());
                    }
                } else {
                    nvest.setNvestStatus(Status.FAILURE.getKey());
                    amexApplicationState.setNvest(nvest);
                    amexApplicationState.setStatus(Status.FAILURE.getKey());
                }
            } catch (Exception e) {
                amexApplicationState.setNvest(nvest);
                amexApplicationState.setFilenetUpload(filenetUpload);
                amexApplicationState.setStatus(Status.FAILURE.getKey());
                logger.error("AmexServiceImpl::pushDataToFilenet::Error::{}", ExceptionUtils.getStackTrace(e));
            }
            amexApplicationStateRepo.save(amexApplicationState);
        }
        logger.info("AmexServiceImpl::pushDataToFilenet::Ended::{}", LocalDateTime.now());
        return message;
    }

    private DocumentDTO getDocumentDetails(String pdfData, String applicationNumber) {
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setApplicationNumber(applicationNumber);
        documentDTO.setFileContent(pdfData);
        return documentDTO;
    }

    private String getBiPdf(String quotationId, Nvest nvest) {
        logger.info("AmexServiceImpl::getBiPdf::Started::{}", LocalDateTime.now());
        String pdfData = "";
        BiPDF biPDF = new BiPDF();
        try {
            biPDF.setQuoteId(quotationId);
            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            NvestPDFResponse nvestPDFResponse = nvestBiPdfService.getBiPdf(quotationId, nvest);
            biPDF.setBiPdfResponse(gson.toJson(nvestPDFResponse));
            if ("Success".equalsIgnoreCase(nvestPDFResponse.getStatus())) {
                biPDF.setBiStatus(Status.SUCCESS.getKey());
                pdfData = nvestPDFResponse.getDataString();
                nvest.setBiPDF(biPDF);
            } else {
                biPDF.setBiStatus(Status.FAILURE.getKey());
                nvest.setBiPDF(biPDF);
            }
        } catch (Exception e) {
            biPDF.setBiStatus(Status.FAILURE.getKey());
            nvest.setBiPDF(biPDF);
            logger.error("AmexServiceImpl::getBiPdf::Error::{}",ExceptionUtils.getStackTrace(e));
        }
        logger.info("AmexServiceImpl::getBiPdf::Ended::{}", LocalDateTime.now());
        return pdfData;
    }

    private void updateIsBiGeneratedColumnInDBForApplicationNumber(String applicationNumber) {
        RetailUploadSubmission retailUploadSubmission = fetchingDBData.getDetailsAsPerApplicationNumber(applicationNumber);
        fetchingDBData.updateDetailsAsPerApplicationNumber(retailUploadSubmission);
    }

}

package com.pmli.amex.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pmli.amex.connector.UploadCustomerDocument;
import com.pmli.amex.model.log.FilenetUpload;
import com.pmli.amex.model.request.filenet.DocumentDTO;
import com.pmli.amex.model.request.filenet.UploadDocument;
import com.pmli.amex.model.response.filenet.DocumentUploadResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class FilenetUploadServiceImpl implements FilenetUploadService {

    private final Logger logger = LoggerFactory.getLogger(FilenetUploadServiceImpl.class);

    @Autowired
    UploadCustomerDocument uploadCustomerDocument;

    @Override
    public DocumentUploadResponse documentUpload(DocumentDTO documentDTO, FilenetUpload filenetUpload) {
        logger.info("FilenetUploadServiceImpl::documentUpload::Started::{}", LocalDateTime.now());
        logger.info("DocumentDTO::{}", documentDTO);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        DocumentUploadResponse documentUploadResponse = new DocumentUploadResponse();
        UploadDocument uploadDocument = new UploadDocument();
        uploadDocument.setLoginId("1234");
        uploadDocument.setLoginType(1);
        uploadDocument.setClientId("123456");
        uploadDocument.setApplicationNo(documentDTO.getApplicationNumber());
        uploadDocument.setDocumentClass("BenefitIllustration");
        uploadDocument.setDocumentTitle(documentDTO.getApplicationNumber() + "_" + "BenefitIllustration");
        uploadDocument.setDocumentContent(documentDTO.getFileContent());
        uploadDocument.setDocumentScope("5");
        try {
            logger.info("UploadDocument::{}", uploadDocument);
            filenetUpload.setFilenetRequest(gson.toJson(uploadDocument));
            documentUploadResponse = uploadCustomerDocument.uploadDocument(uploadDocument);
            filenetUpload.setFilenetResponse(gson.toJson(documentUploadResponse));
            logger.info("DocumentUploadResponse::{}", documentUploadResponse);
        } catch (Exception e) {
            filenetUpload.setFilenetResponse(gson.toJson(documentUploadResponse));
            logger.error("FilenetUploadServiceImpl::documentUpload::Error::{}", ExceptionUtils.getStackTrace(e));
        }
        logger.info("FilenetUploadServiceImpl::documentUpload::Ended::{}", LocalDateTime.now());
        return documentUploadResponse;
    }

    @Override
    public DocumentUploadResponse documentUpload(DocumentDTO documentDTO) {
        logger.info("FilenetUploadServiceImpl::documentUpload::Started::{}", LocalDateTime.now());
        logger.info("DocumentDTO::{}", documentDTO);
        DocumentUploadResponse documentUploadResponse = new DocumentUploadResponse();
        UploadDocument uploadDocument = new UploadDocument();
        uploadDocument.setLoginId("1234");
        uploadDocument.setLoginType(1);
        uploadDocument.setClientId("123456");
        uploadDocument.setApplicationNo(documentDTO.getApplicationNumber());
        uploadDocument.setDocumentClass("BenefitIllustration");
        uploadDocument.setDocumentTitle(documentDTO.getApplicationNumber() + "_" + "BenefitIllustration");
        uploadDocument.setDocumentContent(documentDTO.getFileContent());
        uploadDocument.setDocumentScope("5");
        try {
            logger.info("UploadDocument::{}", uploadDocument);
            documentUploadResponse = uploadCustomerDocument.uploadDocument(uploadDocument);
            logger.info("DocumentUploadResponse::{}", documentUploadResponse);
        } catch (Exception e) {
            logger.error("FilenetUploadServiceImpl::documentUpload::Error::{}",ExceptionUtils.getStackTrace(e));
        }
        logger.info("FilenetUploadServiceImpl::documentUpload::Ended::{}", LocalDateTime.now());
        return documentUploadResponse;
    }
}

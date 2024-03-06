package com.pmli.amex.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pmli.amex.connector.NvestBiPdf;
import com.pmli.amex.model.log.Nvest;
import com.pmli.amex.model.response.NvestPDFResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class NvestBiPdfServiceImpl implements NvestBiPdfService{

    private final Logger logger = LoggerFactory.getLogger(NvestBiPdfServiceImpl.class);

    @Autowired
    NvestBiPdf nvestBiPdf;

    @Override
    public NvestPDFResponse getBiPdf(String quotationId, Nvest nvest) {
        logger.info("NvestBiPdfServiceImpl::getBiPdf::Started::{}", LocalDateTime.now());
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        NvestPDFResponse nvestPDFResponse = new NvestPDFResponse();
        String resJson="";
        try {
            ResponseEntity<String> responseEntity = nvestBiPdf.gtBiPdf(quotationId);
            resJson = responseEntity.getBody();
            nvestPDFResponse = gson.fromJson(resJson, NvestPDFResponse.class);
            if(nvestPDFResponse.getStatus()!=null && "Success".equalsIgnoreCase(nvestPDFResponse.getStatus())){
                logger.info("NvestBiPdfServiceImpl::getBiPdf::Success");
            }else {
                logger.info("NvestBiPdfServiceImpl::getBiPdf::Failed");
            }
        }catch (Exception e){
            logger.error("NvestBiPdfServiceImpl::getBiPdf::Error::{}", ExceptionUtils.getStackTrace(e));
        }
        logger.info("NvestBiPdfServiceImpl::getBiPdf::Ended::{}", LocalDateTime.now());
        return nvestPDFResponse;
    }

    @Override
    public NvestPDFResponse getBiPdf(String quotationId) {
        logger.info("NvestBiPdfServiceImpl::getBiPdf::Started::{}", LocalDateTime.now());
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        NvestPDFResponse nvestPDFResponse = new NvestPDFResponse();
        String resJson="";
        try {
            ResponseEntity<String> responseEntity = nvestBiPdf.gtBiPdf(quotationId);
            resJson = responseEntity.getBody();
            logger.info("resJson::{}", resJson);
            nvestPDFResponse = gson.fromJson(resJson, NvestPDFResponse.class);
            if(nvestPDFResponse.getStatus()!=null && "Success".equalsIgnoreCase(nvestPDFResponse.getStatus())){
                logger.info("NvestBiPdfServiceImpl::getBiPdf::Success");
            }else {
                logger.info("NvestBiPdfServiceImpl::getBiPdf::Failed");
            }
        }catch (Exception e){
            logger.error("NvestBiPdfServiceImpl::getBiPdf::Error::{}",ExceptionUtils.getStackTrace(e));
        }
        logger.info("NvestBiPdfServiceImpl::getBiPdf::Ended::{}", LocalDateTime.now());
        return nvestPDFResponse;
    }
}

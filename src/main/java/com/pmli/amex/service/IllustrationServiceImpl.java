package com.pmli.amex.service;

import com.google.gson.Gson;
import com.pmli.amex.connector.CounterOfferIllustration;
import com.pmli.amex.model.request.illustration.MunichreRequest;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.pmli.amex.model.response.Response;

@Service
public class IllustrationServiceImpl implements IllustrationService {

    private final Logger logger = LoggerFactory.getLogger(IllustrationServiceImpl.class);

    @Autowired
    CounterOfferIllustration counterOfferIllustration;

    @Override
    public Response getIllustrationResponse(MunichreRequest request) {
        logger.info("IllustrationServiceImpl::getIllustrationResponse::Started::{}", LocalDateTime.now());
        String resJson;
        Response response = new Response();
        try {
            ResponseEntity<String> responseEntity = counterOfferIllustration.getLoadedQuotationDetails(request);
            logger.debug("ResponseEntity::{}",responseEntity);
            resJson = responseEntity.getBody();
            logger.debug("resJson::{}", resJson);
            response = new Gson().fromJson(resJson,Response.class);
            logger.debug("IllustrationServiceImpl::getIllustrationResponse::{}",response);
        } catch (Exception e) {
            logger.error("IllustrationServiceImpl::getIllustrationResponse::Error::{}", ExceptionUtils.getStackTrace(e));
        }
        logger.info("IllustrationServiceImpl::getIllustrationResponse::Ended::{}", LocalDateTime.now());
        return response;
    }
}

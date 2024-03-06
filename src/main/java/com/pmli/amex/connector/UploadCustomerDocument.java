package com.pmli.amex.connector;

import com.google.gson.Gson;
import com.pmli.amex.model.request.filenet.UploadDocument;
import com.pmli.amex.model.response.filenet.DocumentUploadResponse;
import com.pmli.amex.model.response.filenet.TokenGenerationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UploadCustomerDocument {

    private final Logger log = LogManager.getLogger(UploadCustomerDocument.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TokenGeneration tokenGeneration;

    @Value("${fileNet.uploadCustomerDocument.service.url}")
    private String fileNetuploadCustomerDocumentConnectorService;
    @Value("${fileNet.header.X-IBM-Client-Id}")
    private String fileNetHeaderXIBMClientId;
    @Value("${fileNet.header.X-IBM-Client-Secret}")
    private String fileNetHeaderXIBMClientSecret;


    public DocumentUploadResponse uploadDocument(UploadDocument uploadDocument) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        TokenGenerationResponse tokenGenerationResponse = tokenGeneration.getAccessToken();
        headers.add("Authorization",tokenGenerationResponse.getAccessToken());
        headers.add("X-IBM-Client-Id",fileNetHeaderXIBMClientId);
        headers.add("X-IBM-Client-Secret",fileNetHeaderXIBMClientSecret);
        HttpEntity<String> entity = new HttpEntity<>(new Gson().toJson(uploadDocument),headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                fileNetuploadCustomerDocumentConnectorService , HttpMethod.POST, entity, String.class);
        log.info("UploadCustomerDocument::responseEntity::{}",responseEntity.getBody());

        return new Gson().fromJson(responseEntity.getBody(),DocumentUploadResponse.class);
    }
}

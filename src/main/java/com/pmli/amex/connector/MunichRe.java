package com.pmli.amex.connector;

import com.google.gson.Gson;
import com.pmli.amex.client.HttpClient;
import com.pmli.amex.model.response.munichre.CreatedLives;
import com.pmli.amex.model.response.munichre.LifeAttribute;
import com.pmli.amex.model.response.munichre.UpdateCaseAttributesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MunichRe {

    private final Logger logger = LoggerFactory.getLogger(MunichRe.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpClient httpClient;

    @Value("${bearerAuth}")
    private String bearerAuth;

    @Value("${base.url}")
    private String baseUrl;

    public UpdateCaseAttributesResponse getCaseAttributes(String caseId){
        UpdateCaseAttributesResponse response = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(bearerAuth);
            String patchUrl = baseUrl + "/" + caseId + "/attributes";
            ResponseEntity<String> responseEntity = httpClient.call(patchUrl,headers, HttpMethod.GET);
            String resJson = responseEntity.getBody();
            if (String.valueOf(responseEntity.getStatusCodeValue()).equals("200")) {
                response = new Gson().fromJson(resJson, UpdateCaseAttributesResponse.class);
            }
        }catch (Exception e){
            logger.error("MunichRe::getCaseAttributes::Error::{}",e.getMessage());
        }
        return response;
    }

    public CreatedLives getCreatedLivesDetail(String caseId){
        CreatedLives createdLives = new CreatedLives();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(bearerAuth);
            String getUrl = baseUrl + "/" + caseId + "/lives";
            ResponseEntity<String> responseEntity = httpClient.call(getUrl,headers, HttpMethod.GET);
            String resJson = responseEntity.getBody();
            if (String.valueOf(responseEntity.getStatusCodeValue()).equals("200")) {
                createdLives = new Gson().fromJson(resJson, CreatedLives.class);
            }
        }catch(Exception e){
            logger.error("MunichRe::getCreatedLivesDetail::Error::{}",e.getMessage());
        }
        return createdLives;
    }

    public LifeAttribute getLifeAttributes (String caseId, String lifeInstance){
        LifeAttribute lifeAttribute = new LifeAttribute();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(bearerAuth);
            String patchUrl = baseUrl + "/" + caseId + "/lives/" + lifeInstance + "/attributes/";
            ResponseEntity<String> responseEntity = httpClient.call(patchUrl,headers,HttpMethod.GET);
            String resJson = responseEntity.getBody();
            if (String.valueOf(responseEntity.getStatusCodeValue()).equals("200")) {
                lifeAttribute = new Gson().fromJson(resJson, LifeAttribute.class);
            }
        }catch (Exception e){
            logger.error("MunichRe::getLifeAttributes::Error::{}",e.getMessage());
        }
        return lifeAttribute;
    }
}

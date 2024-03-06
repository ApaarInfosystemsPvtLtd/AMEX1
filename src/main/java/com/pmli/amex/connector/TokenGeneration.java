package com.pmli.amex.connector;

import com.google.gson.Gson;
import com.pmli.amex.model.response.filenet.TokenGenerationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class TokenGeneration {

    private final Logger log = LogManager.getLogger(TokenGeneration.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${tokenGeneration.service.url}")
    private String tokenGenerationConnectorService;
    @Value("${tokenGeneration.header.X-IBM-Client-Id}")
    private String tokenGenerationHeaderXIBMClientId;
    @Value("${tokenGeneration.header.X-IBM-Client-Secret}")
    private String tokenGenerationHeaderXIBMClientSecret;
    @Value("${tokenGeneration.header.mettype}")
    private String tokenGenerationHeaderMettype;
    @Value("${tokenGeneration.header.subject}")
    private String tokenGenerationHeaderSubject;

    public TokenGenerationResponse getAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.add("X-IBM-Client-Id",tokenGenerationHeaderXIBMClientId);
        headers.add("X-IBM-Client-Secret",tokenGenerationHeaderXIBMClientSecret);
        headers.add("mettype",tokenGenerationHeaderMettype);
        headers.add("subject",tokenGenerationHeaderSubject);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                tokenGenerationConnectorService , HttpMethod.GET, entity, String.class);
        log.info("TokenGeneration::responseEntity::{}",responseEntity.getBody());
        return new Gson().fromJson(responseEntity.getBody(),TokenGenerationResponse.class);
    }
}

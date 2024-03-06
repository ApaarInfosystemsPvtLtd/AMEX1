package com.pmli.amex.connector;

import com.google.gson.Gson;
import com.pmli.amex.model.request.illustration.MunichreRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CounterOfferIllustration {

    @Autowired
    RestTemplate restTemplate;

    @Value("${counterOfferIllustration.url}")
    private String counterOfferIllustrationUrl;

    public ResponseEntity<String> getLoadedQuotationDetails(MunichreRequest request) {
        ResponseEntity<String> responseEntity;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(new Gson().toJson(request),httpHeaders);
        responseEntity = restTemplate.exchange(counterOfferIllustrationUrl, HttpMethod.POST, entity, String.class);
        return responseEntity;
    }
}

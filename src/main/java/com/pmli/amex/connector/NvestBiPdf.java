package com.pmli.amex.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NvestBiPdf {

    @Autowired
    RestTemplate restTemplate;

    @Value("${nvestBiPdfUrl.url}")
    private String nvestBiPdfUrl;

    public ResponseEntity<String> gtBiPdf(String quotationId) {
        ResponseEntity<String> responseEntity;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        String url = nvestBiPdfUrl+"?Tid="+quotationId;
        responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return responseEntity;
    }
}

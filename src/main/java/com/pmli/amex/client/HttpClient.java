package com.pmli.amex.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClient {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<String> call(String url,HttpHeaders headers, HttpMethod method){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url,method,entity,String.class);
    }
}

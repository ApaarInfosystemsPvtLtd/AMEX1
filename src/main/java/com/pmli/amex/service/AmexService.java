package com.pmli.amex.service;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface AmexService {
    String pushDataToFilenet(List<String> applicationNumberList,String process);
}

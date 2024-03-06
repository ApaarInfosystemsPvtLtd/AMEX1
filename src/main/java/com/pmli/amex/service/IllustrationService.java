package com.pmli.amex.service;

import com.pmli.amex.model.request.illustration.MunichreRequest;
import com.pmli.amex.model.response.Response;
import org.springframework.stereotype.Component;

@Component
public interface IllustrationService {

    Response getIllustrationResponse(MunichreRequest request);
}

package com.pmli.amex.service;

import com.google.gson.Gson;
import com.pmli.amex.connector.CounterOfferIllustration;
import com.pmli.amex.model.AmexRequest;
import com.pmli.amex.model.AmexResponse;
import com.pmli.amex.model.request.illustration.MunichreRequest;
import com.pmli.amex.model.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IllustrationServiceImplTest {

    @Autowired
    IllustrationService illustrationService;

    @Autowired
    AmexRequest amexRequest;

    @Autowired
    AmexResponse amexResponse;

    @MockBean
    CounterOfferIllustration counterOfferIllustration;

    @Test
    @DisplayName("Nvest BI Illustration Success Response.")
    public void BiIllustration_Success() {
        MunichreRequest request = new Gson().fromJson(amexRequest.nvestRequest(),MunichreRequest.class);
        ResponseEntity<String> responseEntity = amexResponse.biIllustrationResponseEntity();
        when(counterOfferIllustration.getLoadedQuotationDetails(Mockito.any())).thenReturn(responseEntity);
        Response response = illustrationService.getIllustrationResponse(request);
        assertThat(response.getIllustrationResponse().getStatus()).isEqualTo("Success");
    }
}

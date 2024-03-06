package com.pmli.amex.service;

import com.pmli.amex.connector.CounterOfferIllustration;
import com.pmli.amex.connector.MunichRe;
import com.pmli.amex.connector.NvestBiPdf;
import com.pmli.amex.connector.UploadCustomerDocument;
import com.pmli.amex.model.AmexRequest;
import com.pmli.amex.model.AmexResponse;
import com.pmli.amex.model.log.Nvest;
import com.pmli.amex.model.request.illustration.MunichreRequest;
import com.pmli.amex.model.response.NvestPDFResponse;
import com.pmli.amex.model.response.Response;
import com.pmli.amex.repo.AmexApplicationStateRepo;
import com.pmli.amex.repo.AmexDailyApplicationsRepo;
import com.pmli.amex.repo.NvestParametersRepo;
import com.pmli.amex.util.NvestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AmexServiceTest {

    @Autowired
    AmexRequest amexRequest;

    @Autowired
    AmexResponse amexResponse;

    @MockBean
    AmexApplicationStateRepo amexApplicationStateRepo;

    @MockBean
    AmexDailyApplicationsRepo amexDailyApplicationsRepo;

    @MockBean
    MunichRe munichRe;

    @MockBean
    NvestParametersRepo nvestParametersRepo;

    @MockBean
    CounterOfferIllustration counterOfferIllustration;

    @MockBean
    NvestBiPdf nvestBiPdf;

    @MockBean
    UploadCustomerDocument uploadCustomerDocument;

    @Autowired
    AmexServiceImpl amexService;

    @Test
    public void pushDataToFilenet_Success(){
        when(amexDailyApplicationsRepo.save(Mockito.any())).thenReturn(Mockito.any());
        when(nvestParametersRepo.findByCaseId("865756663anz1")).thenReturn(Optional.ofNullable(amexResponse.nvestRequiredParameterResponse()));
        when(munichRe.getCreatedLivesDetail(Mockito.anyString())).thenReturn(amexResponse.getCreatedLivesResponse());
        when(munichRe.getCaseAttributes(Mockito.anyString())).thenReturn(amexResponse.getUpdateCaseAttributesResponse());
        when(munichRe.getLifeAttributes(Mockito.anyString(),Mockito.anyString())).thenReturn(amexResponse.getLifeAttributesResponse());
        when(counterOfferIllustration.getLoadedQuotationDetails(Mockito.any())).thenReturn(amexResponse.biIllustrationResponseEntity());
        when(nvestBiPdf.gtBiPdf(Mockito.anyString())).thenReturn(amexResponse.biPdfResponseEntity());
        when(uploadCustomerDocument.uploadDocument(Mockito.any())).thenReturn(amexResponse.documentUploadResponse());
        when(amexApplicationStateRepo.save(Mockito.any())).thenReturn(Mockito.any());
        String message = amexService.pushDataToFilenet(amexRequest.getApplicationList_Request(),"Scheduler");
        assertThat(message).isEqualTo("Document added successfully");
    }
}

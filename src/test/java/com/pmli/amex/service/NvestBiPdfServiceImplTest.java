package com.pmli.amex.service;

import com.pmli.amex.connector.NvestBiPdf;
import com.pmli.amex.model.AmexResponse;
import com.pmli.amex.model.log.Nvest;
import com.pmli.amex.model.response.NvestPDFResponse;
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
public class NvestBiPdfServiceImplTest {

    @Autowired
    NvestBiPdfService nvestBiPdfService;

    @MockBean
    NvestBiPdf nvestBiPdf;

    @Autowired
    AmexResponse amexResponse;

    @Test
    @DisplayName("Nvest BI PDF Success Response.")
    public void BiPDF_Success() {
        String quotationID = "123456789";
        ResponseEntity<String> responseEntity = amexResponse.biPdfResponseEntity();
        when(nvestBiPdf.gtBiPdf(Mockito.anyString())).thenReturn(responseEntity);
        NvestPDFResponse response = nvestBiPdfService.getBiPdf(quotationID);
        assertThat(response.getStatus()).isEqualTo("Success");
    }

    @Test
    @DisplayName("Nvest BI PDF Success Response.")
    public void BiPDF_Success1() {
        Nvest nvest = new Nvest();
        String quotationID = "123456789";
        ResponseEntity<String> responseEntity = amexResponse.biPdfResponseEntity();
        when(nvestBiPdf.gtBiPdf(Mockito.anyString())).thenReturn(responseEntity);
        NvestPDFResponse response = nvestBiPdfService.getBiPdf(quotationID,nvest);
        assertThat(response.getStatus()).isEqualTo("Success");
    }

    @Test
    @DisplayName("Nvest BI PDF Failure Response.")
    public void BiPDF_Failure() {
        Nvest nvest = new Nvest();
        String quotationID = "123456789";
        ResponseEntity<String> responseEntity = amexResponse.failureBiPdfResponseEntity();
        when(nvestBiPdf.gtBiPdf(Mockito.anyString())).thenReturn(responseEntity);
        NvestPDFResponse response = nvestBiPdfService.getBiPdf(quotationID,nvest);
        assertThat(response.getStatus()).isEqualTo("Failure");
    }

}

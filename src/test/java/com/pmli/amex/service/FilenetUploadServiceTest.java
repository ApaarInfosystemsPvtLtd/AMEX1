package com.pmli.amex.service;

import com.pmli.amex.connector.UploadCustomerDocument;
import com.pmli.amex.model.AmexRequest;
import com.pmli.amex.model.AmexResponse;
import com.pmli.amex.model.response.filenet.DocumentUploadResponse;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FilenetUploadServiceTest {

    @Autowired
    FilenetUploadServiceImpl filenetUploadService;

    @MockBean
    UploadCustomerDocument uploadCustomerDocument;

    @Autowired
    AmexRequest amexRequest;

    @Autowired
    AmexResponse amexResponse;

    @Test
    @DisplayName("Filenet Upload Success Response.")
    public void filenetUpload_Success() {
        when(uploadCustomerDocument.uploadDocument(Mockito.any())).thenReturn(amexResponse.documentUploadResponse());
        DocumentUploadResponse response = filenetUploadService.documentUpload(amexRequest.documentDTO());
        assertThat(response.getMessage()).isEqualTo("Document Added Successfully");
    }

    @Test(expected = Exception.class)
    @DisplayName("Filenet Upload Failure Response.")
    public void filenetUpload_Failure() {
        when(uploadCustomerDocument.uploadDocument(Mockito.any())).thenThrow(Exception.class);
        DocumentUploadResponse response = filenetUploadService.documentUpload(amexRequest.documentDTO());
        assertThat(response.getMessage()).isEmpty();
    }
}

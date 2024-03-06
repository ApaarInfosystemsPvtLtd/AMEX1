package com.pmli.amex.controller;

import com.pmli.amex.model.AmexRequest;
import com.pmli.amex.model.AmexResponse;
import com.pmli.amex.scheduler.AmexScheduler;
import com.pmli.amex.service.FilenetUploadService;
import com.pmli.amex.service.IllustrationService;
import com.pmli.amex.service.NvestBiPdfService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AmexControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AmexScheduler amexScheduler;

    @MockBean
    IllustrationService illustrationService;

    @MockBean
    NvestBiPdfService nvestBiPdfService;

    @MockBean
    FilenetUploadService filenetUploadService;

    @Autowired
    AmexRequest amexRequest;

    @Autowired
    AmexResponse amexResponse;

    @Test
    public void generateBiIllustration_Success() throws Exception {
        when(illustrationService.getIllustrationResponse(Mockito.any())).thenReturn(amexResponse.biIllustrationResponse());
        this.mockMvc.perform(
                        post("/pmli/v1/biIllustration")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(amexRequest.nvestRequest()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Success")));
    }

    @Test
    public void getBiPDf_Success() throws Exception {
        String quoteID = "80000872600";
        when(nvestBiPdfService.getBiPdf(Mockito.anyString())).thenReturn(amexResponse.biPdfResponse());
        this.mockMvc.perform(
                        get("/pmli/v1/getBiPdf/{quotationId}",quoteID)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Success")));
    }

    @Test
    public void uploadFileDocument_Success() throws Exception {
        when(filenetUploadService.documentUpload(Mockito.any())).thenReturn(amexResponse.documentUploadResponse());
        this.mockMvc.perform(
                        post("/pmli/v1/filentUpload")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(amexRequest.filenetUploadRequest()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Document Added Successfully")));
    }

    @Test
    public void callAmexProcessAsPerApplications_Success() throws Exception {
        when(amexScheduler.amexApiProcess(Mockito.any())).thenReturn("FLOW SUCCESS");
        this.mockMvc.perform(
                        post("/pmli/v1/amex/applicationNumbers")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(amexRequest.getApplicationList()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("DONE")));
    }

    @Test
    public void callAmexProcess() throws Exception {
        when(amexScheduler.amexApiProcess(Mockito.any())).thenReturn("DONE");
        this.mockMvc.perform(
                        get("/pmli/v1/amex"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("DONE")));
    }

}

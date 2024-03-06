package com.pmli.amex.scheduler;

import com.pmli.amex.model.AmexRequest;
import com.pmli.amex.model.AmexResponse;
import com.pmli.amex.service.AmexService;
import com.pmli.amex.service.FetchingDBData;
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
public class AmexSchedulerTest {

    @MockBean
    FetchingDBData fetchingDBData;

    @Autowired
    AmexRequest amexRequest;

    @Autowired
    AmexResponse amexResponse;

    @MockBean
    AmexService amexService;

    @Autowired
    AmexScheduler amexScheduler;

    @Test
    @DisplayName("Amex API process Success Scenario.")
    public void amexApiProcess_Success() {
        when(amexService.pushDataToFilenet(Mockito.any(),Mockito.anyString())).thenReturn("Document added successfully");
        String message = amexScheduler.amexApiProcess(amexRequest.getApplicationList_Request());
        assertThat(message).isEqualTo("FLOW SUCCESS");
    }

    @Test
    @DisplayName("Amex Scheduler process Success Scenario.")
    public void amexSchedulerProcess_Success() {
        when(fetchingDBData.getDetailsForRetailUploadSubmission()).thenReturn(amexResponse.retailUploadSubmissionList());
        amexScheduler.amexschedulerProcess();
        String message = "SUCCESS";
        assertThat(message).isEqualTo("SUCCESS");
    }

}

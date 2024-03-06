package com.pmli.amex.connector;

import com.pmli.amex.client.HttpClient;
import com.pmli.amex.model.AmexRequest;
import com.pmli.amex.model.AmexResponse;
import com.pmli.amex.model.response.munichre.CreatedLives;
import com.pmli.amex.model.response.munichre.LifeAttribute;
import com.pmli.amex.model.response.munichre.UpdateCaseAttributesResponse;
import org.junit.Test;
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
public class MunichReTest {

    @Autowired
    AmexRequest amexRequest;

    @Autowired
    AmexResponse amexResponse;

    @MockBean
    HttpClient httpClient;

    @Autowired
    MunichRe munichRe;

    private static final String caseID = "865756663anz1";
    private static final String lifeInstance ="1";

    @Test
    public void getCaseAttributes_Success(){
        when(httpClient.call(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(amexResponse.getCaseAttributesResponse());
        UpdateCaseAttributesResponse updateCaseAttributesResponse = munichRe.getCaseAttributes(caseID);
        assertThat(updateCaseAttributesResponse.getAttributes()).containsEntry("ADVERSE_AGENT_REPORT_FLAG","true");
    }

    @Test
    public void getCreatedLivesDetail_Success(){
        when(httpClient.call(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(amexResponse.getCreatedLivesDetailResponse());
        CreatedLives createdLives = munichRe.getCreatedLivesDetail(caseID);
        assertThat(createdLives.getContent().size()).isEqualTo(1);
    }

    @Test
    public void getLifeAttributes_Success(){
        when(httpClient.call(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(amexResponse.getLifeAttributesResponseEntity());
        LifeAttribute lifeAttribute = munichRe.getLifeAttributes(caseID,lifeInstance);
        assertThat(lifeAttribute.getAttributes()).containsEntry("ADDRESS_PROOF_PROVIDED_FLAG","true");
    }

    @Test(expected = Exception.class)
    public void getCaseAttributes_Failure(){
        when(httpClient.call(Mockito.any(),Mockito.any(),Mockito.any())).thenThrow(Exception.class);
        UpdateCaseAttributesResponse updateCaseAttributesResponse = munichRe.getCaseAttributes(caseID);
        assertThat(updateCaseAttributesResponse).isNull();
    }
}

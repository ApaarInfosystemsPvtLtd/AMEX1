package com.pmli.amex.util;

import com.pmli.amex.connector.MunichRe;
import com.pmli.amex.model.AmexRequest;
import com.pmli.amex.model.AmexResponse;
import com.pmli.amex.model.request.illustration.MunichreRequest;
import com.pmli.amex.repo.NvestParametersRepo;
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
public class NvestMapperTest {

    @Autowired
    AmexRequest amexRequest;

    @Autowired
    AmexResponse amexResponse;

    @MockBean
    MunichRe munichRe;

    @Autowired
    NvestMapper nvestMapper;

    @MockBean
    NvestParametersRepo nvestParametersRepo;


    @Test
    public void getMunichReRequest(){
        when(nvestParametersRepo.findByCaseId("865756663anz1")).thenReturn(Optional.ofNullable(amexResponse.nvestRequiredParameterResponse()));
        when(munichRe.getCreatedLivesDetail(Mockito.anyString())).thenReturn(amexResponse.getCreatedLivesResponse());
        when(munichRe.getCaseAttributes(Mockito.anyString())).thenReturn(amexResponse.getUpdateCaseAttributesResponse());
        when(munichRe.getLifeAttributes(Mockito.anyString(),Mockito.anyString())).thenReturn(amexResponse.getLifeAttributesResponse());
        MunichreRequest request = nvestMapper.getIllustrationCounterofferParameter("865756663anz1");
        assertThat(request.getUniquekey()).isEqualTo("865756663anz1");
    }
}

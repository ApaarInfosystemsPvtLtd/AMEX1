package com.pmli.amex.service;

import com.pmli.amex.model.log.Nvest;
import com.pmli.amex.model.response.NvestPDFResponse;
import org.springframework.stereotype.Component;

@Component
public interface NvestBiPdfService {

    NvestPDFResponse getBiPdf(String quotationId, Nvest nvest);
    NvestPDFResponse getBiPdf(String quotationId);
}

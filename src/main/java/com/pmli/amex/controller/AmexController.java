package com.pmli.amex.controller;


import com.pmli.amex.model.request.filenet.DocumentDTO;
import com.pmli.amex.model.request.illustration.MunichreRequest;
import com.pmli.amex.model.response.NvestPDFResponse;
import com.pmli.amex.model.response.Response;
import com.pmli.amex.model.response.filenet.DocumentUploadResponse;
import com.pmli.amex.scheduler.AmexScheduler;
import com.pmli.amex.service.*;
import com.pmli.amex.util.NvestMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pmli/v1")
public class AmexController {

    @Autowired
    IllustrationService illustrationService;

    @Autowired
    FilenetUploadService filenetUploadService;

    @Autowired
    NvestBiPdfService nvestBiPdfService;

    @Autowired
    AmexScheduler amexScheduler;

    @Autowired
    FetchingDBData fetchingDBData;

    @Autowired
    NvestMapper1 nvestMapper1;

    @PostMapping("/biIllustration")
    public ResponseEntity<Response> generateBiIllustration(@RequestBody MunichreRequest request) {
        Response response = illustrationService.getIllustrationResponse(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getBiPdf/{quotationId}")
    public ResponseEntity<NvestPDFResponse> getBiPDf(@PathVariable String quotationId) {
        NvestPDFResponse nvestPDFResponse = nvestBiPdfService.getBiPdf(quotationId);
        return new ResponseEntity<>(nvestPDFResponse, HttpStatus.OK);
    }

    @PostMapping("/filentUpload")
    public ResponseEntity<DocumentUploadResponse> uploadFileDocument(@RequestBody DocumentDTO documentDTO) {
        DocumentUploadResponse documentUploadResponse = filenetUploadService.documentUpload(documentDTO);
        return new ResponseEntity<>(documentUploadResponse, HttpStatus.OK);
    }

    @PostMapping("/amex/applicationNumbers")
    public ResponseEntity<String> callAmexProcessAsPerApplications(@RequestBody List<String> applicationNumbers) {
        amexScheduler.amexApiProcess(applicationNumbers);
        return new ResponseEntity<>("DONE", HttpStatus.OK);
    }

    @GetMapping("/amex")
    public ResponseEntity<String> callAmexProcess() {
        amexScheduler.amexschedulerProcess();
        return new ResponseEntity<>("DONE", HttpStatus.OK);
    }

    @GetMapping("/updateDetails/{applicationNumber}")
    public ResponseEntity<String> updateAmexDetailsInDB(@PathVariable String applicationNumber) {
        fetchingDBData.updateDetailsAsPerApplicationNumber(applicationNumber);
        return new ResponseEntity<>("DONE", HttpStatus.OK);
    }

    @GetMapping("/amex-as-per-application/{applicationNumber}")
    public ResponseEntity<String> munichReRequestChecking(@PathVariable String applicationNumber) {
        List<String> applicationNumberList = new ArrayList<>();
        applicationNumberList.add(applicationNumber);
        amexScheduler.amexApiProcess(applicationNumberList);
        return new ResponseEntity<>("Process DONE.!", HttpStatus.OK);
    }
}

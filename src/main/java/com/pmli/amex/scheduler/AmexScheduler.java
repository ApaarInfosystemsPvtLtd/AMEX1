package com.pmli.amex.scheduler;

import com.pmli.amex.model.request.db.RetailUploadSubmission;
import com.pmli.amex.service.AmexService;
import com.pmli.amex.service.FetchingDBData;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class AmexScheduler {

    private final Logger log = LogManager.getLogger(AmexScheduler.class);

    @Autowired
    AmexService amexService;

    @Autowired
    FetchingDBData fetchingDBData;


    public String amexApiProcess(List<String> applicationNumberList){
        String message="";
        log.info("####### Amex API Process Started::{}", LocalDateTime.now());
        try{
            if(applicationNumberList!=null) {
                log.info("ApplicationNumberList List::{}",applicationNumberList);
                amexService.pushDataToFilenet(applicationNumberList,"API_Endpoint");
                message ="FLOW SUCCESS";
            }
        }catch (Exception e){
            message ="FLOW FAILED";
            log.error("AmexScheduler::amexProcess::{}", ExceptionUtils.getStackTrace(e));
        }
        log.info("####### Amex API Process Ended::{} ######", LocalDateTime.now());
        return message;
    }

    @Scheduled(cron = "0 0 0/2 1/1 * ?")
    public void amexschedulerProcess(){
        log.info("###### Amex process scheduler Started::{} ######", LocalDateTime.now());
        try{
            List<RetailUploadSubmission> retailUploadSubmissions = fetchingDBData.getDetailsForRetailUploadSubmission();
            if(!retailUploadSubmissions.isEmpty()) {
                List<String> applicationNumberList = new ArrayList<>();
                for(RetailUploadSubmission retailUploadSubmission: retailUploadSubmissions) {
                    applicationNumberList.add(retailUploadSubmission.getAPPLICATIONNUMBER());
                }
                amexService.pushDataToFilenet(applicationNumberList,"Scheduler");
            }
        }catch (Exception e){
            log.error("AmexScheduler::amexProcess::{}",ExceptionUtils.getStackTrace(e));
        }
        log.info("##### Amex process scheduler Ended::{} ######", LocalDateTime.now());
    }

}

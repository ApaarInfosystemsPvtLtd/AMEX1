package com.pmli.amex.util;

import com.pmli.amex.model.request.illustration.MunichreRequest;
import com.pmli.amex.model.subappaform.Pidetails;
import com.pmli.amex.model.subappaform.Productdetails;
import com.pmli.amex.model.subappaform.Tma;
import com.pmli.amex.service.FetchingDBData;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Component
public class NvestMapper1 {

    @Autowired
    FetchingDBData fetchingDBData;

    private final Logger log = LogManager.getLogger(FetchingDBData.class);

    public MunichreRequest getIllustrationCounterofferParameter(String caseId) {
        log.info("NvestMapper1::getIllustrationCounterofferParameter::Started::" + LocalDateTime.now());
        MunichreRequest request = new MunichreRequest();
        Tma tma = null;
        try {
            tma = getSubAppFormData(caseId);

            Pidetails pidetails = tma.getBody().getPidetails();
            //Podetails podetails = tma.getBody().getPodetails();
            Productdetails productdetails = tma.getBody().getProductdetails();
            request.setUniquekey(caseId);
            request.setName(pidetails.getFirstname() + " " + pidetails.getLastname());
            request.setDob(dateFormatter(pidetails.getDob()));
            request.setGender(pidetails.getGender());
            request.setPremiumpayfreq(getPaymentMode(productdetails.getPremiumpayfreq()));
            request.setProductcode(productdetails.getProductcode());
            request.setPolicyterm(productdetails.getPolicyterm());
            request.setPremiumpayterm(productdetails.getPremiumpayterm());
            request.setFaceamount(productdetails.getFaceamount());
            request.setMonthlyincome(productdetails.getMonthlyincome());
            request.setBenefitoption(productdetails.getBenefitoption());
            request.setProductoption(productdetails.getProductoption());
            request.setPrimannualincome(pidetails.getAnnualincome());
            if ("Non Smoker".equalsIgnoreCase(productdetails.getClassoflives())) {
                request.setClassoflives("NO");
            } else {
                request.setClassoflives("YES");
            }
        } catch (JAXBException e) {
            log.error("NvestMapper1::getIllustrationCounterofferParameter::error::" + ExceptionUtils.getStackTrace(e));
        }
        log.info("MunichRequest From NvestMapper class::{}", request);
        log.info("NvestMapper1::getIllustrationCounterofferParameter::Ended::{}", LocalDateTime.now());
        return request;
    }

    private Tma getSubAppFormData(String applicationNumber) throws JAXBException {
        log.info("NvestMapper1::getSubAppFormData::Ended::" + LocalDateTime.now());
        String dataXml = fetchingDBData.getSubAppFormDetails(applicationNumber);
        log.info("getSubAppFormData::DataXML::" + dataXml);
        log.info("NvestMapper1::getSubAppFormData::Ended::" + LocalDateTime.now());
        return populateSubAppFormData(dataXml);
    }

    private Tma populateSubAppFormData(String xml) throws JAXBException {
        log.info("NvestMapper1::populateSubAppFormData::Ended::" + LocalDateTime.now());
        JAXBContext jaxbContext = JAXBContext.newInstance(Tma.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        log.info("NvestMapper1::populateSubAppFormData::Ended::" + LocalDateTime.now());
        Tma tma = (Tma) unmarshaller.unmarshal(reader);
        return tma;
    }

    private String dateFormatter(String inputDate) {
        String reformattedStr = null;
        SimpleDateFormat fromUser = new SimpleDateFormat("dd/MMM/yyyy");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            reformattedStr = myFormat.format(fromUser.parse(inputDate));
        } catch (ParseException e) {
            log.error("NvestMapper1::dateFormatter::Ended::{}", ExceptionUtils.getStackTrace(e));
        }
        return reformattedStr;
    }

    private String getPaymentMode(String premiumPayFreq) {
        String paymentMode = "";
        switch (premiumPayFreq) {
            case "05":
                paymentMode = "U";
                break;
            case "01":
                paymentMode = "A";
                break;
            case "02":
                paymentMode = "S";
                break;
            case "03":
                paymentMode = "T";
                break;
            case "o4":
                paymentMode = "M";
                break;
            default:
                break;
        }
        return paymentMode;
    }

}

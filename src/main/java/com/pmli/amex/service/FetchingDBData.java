package com.pmli.amex.service;

import com.pmli.amex.constants.RetailUploadSubmissionDB;
import com.pmli.amex.model.request.db.RetailUploadSubmission;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class FetchingDBData {

    private final Logger log = LogManager.getLogger(FetchingDBData.class);

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String pass;

    @Value("${spring.datasource.updateUsername}")
    private String updateUser;
    @Value("${spring.datasource.updatePassword}")
    private String updatePass;

    public List<RetailUploadSubmission> getDetailsForRetailUploadSubmission() {
        log.info("FetchingDBData::getDetailsForRetailUploadSubmission::Started::{}", LocalDateTime.now());
        List<RetailUploadSubmission> retailUploadSubmissionList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement stmt = con.createStatement()) {
            String query = "select * from tblretailupload_submission(nolock) where ISIFPINITIATED = 'Y' and ISBIPDFGENERATED ='N' and convert(varchar(10),CREATEDDATE,103)=convert(varchar(10),getdate(),103);";
            log.info("getDetailsForRetailUploadSubmission::Select_Query::{}", query);
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                RetailUploadSubmission retailUploadSubmission = new RetailUploadSubmission();
                retailUploadSubmission.setRETAIL_ID(String.valueOf(resultSet.getLong(RetailUploadSubmissionDB.RETAIL_ID.getKey())));
                retailUploadSubmission.setAPPLICATIONNUMBER(String.valueOf(resultSet.getLong(RetailUploadSubmissionDB.APPLICATIONNUMBER.getKey())));
                retailUploadSubmission.setISBIPDFGENERATED(resultSet.getString(RetailUploadSubmissionDB.ISBIPDFGENERATED.getKey()));
                retailUploadSubmission.setISIFPINITIATED(resultSet.getString(RetailUploadSubmissionDB.ISIFPINITIATED.getKey()));
                retailUploadSubmission.setCREATEDDATE(String.valueOf(resultSet.getDate(RetailUploadSubmissionDB.CREATEDDATE.getKey())));
                retailUploadSubmissionList.add(retailUploadSubmission);
            }
            log.info("RetailUploadSubmission Details::Size::{}", retailUploadSubmissionList.size());
        } catch (Exception exe) {
            log.error("FetchingDBData::getDetailsForRetailUploadSubmission::Error::{}", ExceptionUtils.getStackTrace(exe));
        }
        log.info("FetchingDBData::getDetailsForRetailUploadSubmission::Ended::{}", LocalDateTime.now());
        return retailUploadSubmissionList;
    }

    public RetailUploadSubmission getDetailsAsPerApplicationNumber(String applicationNumber) {
        log.info("FetchingDBData::getDetailsAsPerApplicationNumber::Started::{}", LocalDateTime.now());
        RetailUploadSubmission retailUploadSubmission = new RetailUploadSubmission();
        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement stmt = con.createStatement()) {
            String query = "select  * from tblretailupload_submission(nolock) where APPLICATIONNUMBER = '" + applicationNumber + "'";
            log.info("getDetailsAsPerApplicationNumber::Select_Query::{}", query);
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                retailUploadSubmission.setRETAIL_ID(String.valueOf(resultSet.getLong(RetailUploadSubmissionDB.RETAIL_ID.getKey())));
                retailUploadSubmission.setAPPLICATIONNUMBER(String.valueOf(resultSet.getLong(RetailUploadSubmissionDB.APPLICATIONNUMBER.getKey())));
                retailUploadSubmission.setISBIPDFGENERATED(resultSet.getString(RetailUploadSubmissionDB.ISBIPDFGENERATED.getKey()));
                retailUploadSubmission.setISIFPINITIATED(resultSet.getString(RetailUploadSubmissionDB.ISIFPINITIATED.getKey()));
                retailUploadSubmission.setCREATEDDATE(String.valueOf(resultSet.getDate(RetailUploadSubmissionDB.CREATEDDATE.getKey())));
            }
        } catch (Exception exe) {
            log.error("FetchingDBData::getDetailsAsPerApplicationNumber::Error::{}", ExceptionUtils.getStackTrace(exe));
        }
        log.info("FetchingDBData::getDetailsAsPerApplicationNumber::Ended::{}", LocalDateTime.now());
        return retailUploadSubmission;
    }

    public void updateDetailsAsPerApplicationNumber(RetailUploadSubmission retailUploadSubmission) {
        log.info("FetchingDBData::updateDetailsAsPerApplicationNumber::Started::{}", LocalDateTime.now());
        try (Connection con = DriverManager.getConnection(url, updateUser, updatePass);
             Statement stmt = con.createStatement()) {
            String query = "Update tblretailupload_submission set ISBIPDFGENERATED = 'Y' where RETAIL_ID = '" + retailUploadSubmission.getRETAIL_ID() + "' and APPLICATIONNUMBER = '" + retailUploadSubmission.getAPPLICATIONNUMBER() + "'";
            log.info("updateDetailsAsPerApplicationNumber::Update_Query::{}", query);
            stmt.executeUpdate(query);
            log.info("Details has been update for application number::{}", retailUploadSubmission.getAPPLICATIONNUMBER());
        } catch (Exception exe) {
            log.error("FetchingDBData::updateDetailsAsPerApplicationNumber::Error::{}", ExceptionUtils.getStackTrace(exe));
        }
        log.info("FetchingDBData::updateDetailsAsPerApplicationNumber::Ended::{}", LocalDateTime.now());
    }


    public void updateDetailsAsPerApplicationNumber(String applicationNumber) {
        log.info("FetchingDBData::updateDetailsAsPerApplicationNumber::Started::{}", LocalDateTime.now());
        try (Connection con = DriverManager.getConnection(url, updateUser, updatePass);
             Statement stmt = con.createStatement()) {
            String query = "Update tblretailupload_submission set ISBIPDFGENERATED = 'Y' where APPLICATIONNUMBER = '" + applicationNumber + "'";
            log.info("updateDetailsAsPerApplicationNumber::Update_Query::{}", query);
            stmt.executeUpdate(query);
            log.info("Details has been update for application number::{}", applicationNumber);
        } catch (Exception exe) {
            log.error("FetchingDBData::updateDetailsAsPerApplicationNumber::Error::{}", ExceptionUtils.getStackTrace(exe));
        }
        log.info("FetchingDBData::updateDetailsAsPerApplicationNumber::Ended::{}", LocalDateTime.now());
    }

    public String getAppFormDetails(String applicationNumber){
        String dataXml=null;
        log.info("FetchingDBData::getAppFormDetails::Started::{}", LocalDateTime.now());
        try (Connection con = DriverManager.getConnection(url, updateUser, updatePass);
             Statement stmt = con.createStatement()) {
            String query = "select * from tblappform where applicationNumber = '" + applicationNumber + "'";
            log.info("getAppFormDetails::Update_Query::{}", query);
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                dataXml = getDataXml(resultSet.getClob("DATA_STORE_XML"));
            }
        } catch (Exception exe) {
            log.error("FetchingDBData::getAppFormDetails::Error::{}", ExceptionUtils.getStackTrace(exe));
        }
        log.info("FetchingDBData::getAppFormDetails::Ended::{}", LocalDateTime.now());
        return dataXml;
    }

    public String getSubAppFormDetails(String applicationNumber){
        String dataXml=null;
        log.info("FetchingDBData::getSubAppFormDetails::Started::{}", LocalDateTime.now());
        try (Connection con = DriverManager.getConnection(url, updateUser, updatePass);
             Statement stmt = con.createStatement()) {
            String query = "select * from tblSubAppForm where applicationNumber = '" + applicationNumber + "'";
            log.info("getSubAppFormDetails::Update_Query::{}", query);
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                dataXml = getDataXml(resultSet.getClob("DATA_STORE_XML"));
            }
        } catch (Exception exe) {
            log.error("FetchingDBData::getSubAppFormDetails::Error::{}", ExceptionUtils.getStackTrace(exe));
        }
        log.info("FetchingDBData::getSubAppFormDetails::Ended::{}", LocalDateTime.now());
        return dataXml;
    }

    private String getDataXml(Clob clob) throws SQLException, IOException {
        Reader r = clob.getCharacterStream();
        StringBuilder buffer = new StringBuilder();
        int ch;
        while ((ch = r.read()) != -1) {
            buffer.append("" + (char) ch);
        }
        return buffer.toString();
    }

}

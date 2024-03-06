package com.pmli.amex.model.response.illustration;

import java.util.ArrayList;
import java.util.List;

public class IllustrationResponse {

    private String bijson;
    private String bijson2;
    List<InputValidationStatus> inputValidationStatus = new ArrayList<>();
    private String message;
    private String quotationId;
    private String riderBIJson;
    private String status;
    private String step;
    private String transactionId;
    private String balic_Quoteid;

    public String getBijson() {
        return bijson;
    }

    public void setBijson(String bijson) {
        this.bijson = bijson;
    }

    public String getBijson2() {
        return bijson2;
    }

    public void setBijson2(String bijson2) {
        this.bijson2 = bijson2;
    }

    public List<InputValidationStatus> getInputValidationStatus() {
        return inputValidationStatus;
    }

    public void setInputValidationStatus(List<InputValidationStatus> inputValidationStatus) {
        this.inputValidationStatus = inputValidationStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }

    public String getRiderBIJson() {
        return riderBIJson;
    }

    public void setRiderBIJson(String riderBIJson) {
        this.riderBIJson = riderBIJson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getBalic_Quoteid() {
        return balic_Quoteid;
    }

    public void setBalic_Quoteid(String balic_Quoteid) {
        this.balic_Quoteid = balic_Quoteid;
    }
}

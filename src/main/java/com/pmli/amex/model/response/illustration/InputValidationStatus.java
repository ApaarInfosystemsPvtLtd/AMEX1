package com.pmli.amex.model.response.illustration;

import java.util.ArrayList;
import java.util.List;

public class InputValidationStatus {

    private String ageMasterId;
    private String annualPremium;
    private String entryAge;
    List<ErrorMessage> errorMessage = new ArrayList<>();
    private String failedCount;
    private String generalError;
    List<IpKeyword> ipKeyword = new ArrayList<>();
    List<IpKwMessage> ipKwMessage= new ArrayList<>();
    private String loadAnnPrems;
    private String MIError;
    private String maturityAge;
    private String modalPremium;
    private String modeDisc;
    private String ModeFreq;
    private String monthlyIncome;
    List<OptionError> optionError = new ArrayList<>();
    private String PPT;
    private String PT;
    private String platform;
    private String premium;
    private String productId;
    private String reverseCalcInput;
    private String riderMessage;
    private String SA;
    private String SAMF;
    private String SAMFError;
    private String sumAssured;
    private String tax;
    private String tax_2;
    private String ulipSA;
    List<WOPProducts> WOPProducts = new ArrayList<>();

    public String getAgeMasterId() {
        return ageMasterId;
    }

    public void setAgeMasterId(String ageMasterId) {
        this.ageMasterId = ageMasterId;
    }

    public String getAnnualPremium() {
        return annualPremium;
    }

    public void setAnnualPremium(String annualPremium) {
        this.annualPremium = annualPremium;
    }

    public String getEntryAge() {
        return entryAge;
    }

    public void setEntryAge(String entryAge) {
        this.entryAge = entryAge;
    }

    public List<ErrorMessage> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(List<ErrorMessage> errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(String failedCount) {
        this.failedCount = failedCount;
    }

    public String getGeneralError() {
        return generalError;
    }

    public void setGeneralError(String generalError) {
        this.generalError = generalError;
    }

    public List<IpKeyword> getIpKeyword() {
        return ipKeyword;
    }

    public void setIpKeyword(List<IpKeyword> ipKeyword) {
        this.ipKeyword = ipKeyword;
    }

    public List<IpKwMessage> getIpKwMessage() {
        return ipKwMessage;
    }

    public void setIpKwMessage(List<IpKwMessage> ipKwMessage) {
        this.ipKwMessage = ipKwMessage;
    }

    public String getLoadAnnPrems() {
        return loadAnnPrems;
    }

    public void setLoadAnnPrems(String loadAnnPrems) {
        this.loadAnnPrems = loadAnnPrems;
    }

    public String getMIError() {
        return MIError;
    }

    public void setMIError(String MIError) {
        this.MIError = MIError;
    }

    public String getMaturityAge() {
        return maturityAge;
    }

    public void setMaturityAge(String maturityAge) {
        this.maturityAge = maturityAge;
    }

    public String getModalPremium() {
        return modalPremium;
    }

    public void setModalPremium(String modalPremium) {
        this.modalPremium = modalPremium;
    }

    public String getModeDisc() {
        return modeDisc;
    }

    public void setModeDisc(String modeDisc) {
        this.modeDisc = modeDisc;
    }

    public String getModeFreq() {
        return ModeFreq;
    }

    public void setModeFreq(String modeFreq) {
        ModeFreq = modeFreq;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public List<OptionError> getOptionError() {
        return optionError;
    }

    public void setOptionError(List<OptionError> optionError) {
        this.optionError = optionError;
    }

    public String getPPT() {
        return PPT;
    }

    public void setPPT(String PPT) {
        this.PPT = PPT;
    }

    public String getPT() {
        return PT;
    }

    public void setPT(String PT) {
        this.PT = PT;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getReverseCalcInput() {
        return reverseCalcInput;
    }

    public void setReverseCalcInput(String reverseCalcInput) {
        this.reverseCalcInput = reverseCalcInput;
    }

    public String getRiderMessage() {
        return riderMessage;
    }

    public void setRiderMessage(String riderMessage) {
        this.riderMessage = riderMessage;
    }

    public String getSA() {
        return SA;
    }

    public void setSA(String SA) {
        this.SA = SA;
    }

    public String getSAMF() {
        return SAMF;
    }

    public void setSAMF(String SAMF) {
        this.SAMF = SAMF;
    }

    public String getSAMFError() {
        return SAMFError;
    }

    public void setSAMFError(String SAMFError) {
        this.SAMFError = SAMFError;
    }

    public String getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(String sumAssured) {
        this.sumAssured = sumAssured;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTax_2() {
        return tax_2;
    }

    public void setTax_2(String tax_2) {
        this.tax_2 = tax_2;
    }

    public String getUlipSA() {
        return ulipSA;
    }

    public void setUlipSA(String ulipSA) {
        this.ulipSA = ulipSA;
    }

    public List<com.pmli.amex.model.response.illustration.WOPProducts> getWOPProducts() {
        return WOPProducts;
    }

    public void setWOPProducts(List<com.pmli.amex.model.response.illustration.WOPProducts> WOPProducts) {
        this.WOPProducts = WOPProducts;
    }
}

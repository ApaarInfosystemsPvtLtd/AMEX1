package com.pmli.amex.util;

import com.pmli.amex.connector.MunichRe;
import com.pmli.amex.model.request.db.NvestRequiredParameter;
import com.pmli.amex.model.request.illustration.MunichreRequest;
import com.pmli.amex.model.response.munichre.CreatedLives;
import com.pmli.amex.model.response.munichre.Life;
import com.pmli.amex.model.response.munichre.LifeAttribute;
import com.pmli.amex.model.response.munichre.UpdateCaseAttributesResponse;
import com.pmli.amex.repo.NvestParametersRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class NvestMapper {

    private final Logger logger = LoggerFactory.getLogger(NvestMapper.class);

    @Autowired
    MunichRe munichRe;

    @Autowired
    NvestParametersRepo nvestParametersRepo;

    public MunichreRequest getIllustrationCounterofferParameter(String caseId){
        CreatedLives createdLives = munichRe.getCreatedLivesDetail(caseId);
        List<Life> lives = createdLives.getContent();
        UpdateCaseAttributesResponse response = munichRe.getCaseAttributes(caseId);
        Map<String,String> caseLevelAttributes = response.getAttributes();
        MunichreRequest parameters = setCaseLevelAttributes(caseLevelAttributes,caseId);
        parameters = getLifeLevelAttributes(caseId,lives,parameters);
        parameters = setTheParametersComingFromSwift(parameters,caseId);
        return parameters;
    }

    public MunichreRequest setCaseLevelAttributes(Map<String,String> caseLevelAttributes, String caseId){
        MunichreRequest counterofferAndIllustrationParameter = new MunichreRequest();
        counterofferAndIllustrationParameter.setUniquekey(caseId);
        counterofferAndIllustrationParameter.setFormtype(caseLevelAttributes.get("UNDERWRITING_METHOD"));
        counterofferAndIllustrationParameter.setProductcode(caseLevelAttributes.get("PRODUCT_CODE"));
        counterofferAndIllustrationParameter.setGender(caseLevelAttributes.get(""));  // Life level
        counterofferAndIllustrationParameter.setSecannudobinfo(caseLevelAttributes.get("")); // Life 2- DOB
        counterofferAndIllustrationParameter.setMetsmartpremium(caseLevelAttributes.get("MODAL_PREMIUM_EXCL_TAXES"));
        counterofferAndIllustrationParameter.setMetsmartmultiple(caseLevelAttributes.get("PREMIUM_MULTIPLE"));
        counterofferAndIllustrationParameter.setFaceamount(caseLevelAttributes.get("")); // Life level
        counterofferAndIllustrationParameter.setPolicyterm(caseLevelAttributes.get("POLICY_TERM"));
        counterofferAndIllustrationParameter.setPremiumpayterm(caseLevelAttributes.get("PREMIUM_PAYING_TERM"));
        counterofferAndIllustrationParameter.setPremiumpayfreq(caseLevelAttributes.get("PREMIUM_PAYMENT_FREQUENCY"));
        counterofferAndIllustrationParameter.setDob(caseLevelAttributes.get("")); // PO_DATE_OF_BIRTH, DATE_OF_BIRTH in each life
        counterofferAndIllustrationParameter.setRenewalpaymode(caseLevelAttributes.get("RENEWAL_PAYMENT_MODE"));
        counterofferAndIllustrationParameter.setProductoption(caseLevelAttributes.get("")); //New_Tag to be created.
        counterofferAndIllustrationParameter.setPaymentoption(caseLevelAttributes.get("PREMIUM_TYPE"));
        counterofferAndIllustrationParameter.setFamilycarebenefit(caseLevelAttributes.get("")); //New_Tag to be created.
        counterofferAndIllustrationParameter.setMonthlyincome(caseLevelAttributes.get("")); // Didnot find attribute ANNUAL_GROSS_INCOME_DECLAREDin case level attributes
        counterofferAndIllustrationParameter.setSecondaryfaceamount(caseLevelAttributes.get("")); //FACE_AMOUNT for the second life
        counterofferAndIllustrationParameter.setSecondaryincomesource(caseLevelAttributes.get("")); // OCCUPATION for the secondary life
        counterofferAndIllustrationParameter.setLifepartner(caseLevelAttributes.get("")); // need clarification, if its relationship with PI then AI_TO_PI_RELATIONSHIP
        counterofferAndIllustrationParameter.setClassoflives(caseLevelAttributes.get("")); // Smoker_Status (If yes "1", No "0")
        counterofferAndIllustrationParameter.setMailaddressstate(caseLevelAttributes.get("")); // STATE for respective life
        counterofferAndIllustrationParameter.setSaMultiple(caseLevelAttributes.get("")); // Not given by the SWIFT team
        counterofferAndIllustrationParameter.setDefermentperiod(caseLevelAttributes.get("")); // New_Tag to be created.
        counterofferAndIllustrationParameter.setBonusoption(caseLevelAttributes.get("")); // New_Tag to be created.
        counterofferAndIllustrationParameter.setIncomepayoutoption(caseLevelAttributes.get("")); // New_Tag to be created.
        counterofferAndIllustrationParameter.setIsstdriderval(caseLevelAttributes.get("")); // Not given by the SWIFT team
        counterofferAndIllustrationParameter.setPrimannualincome(caseLevelAttributes.get("")); // ANNUAL_GROSS_INCOME_DECLARED (for life1)
        counterofferAndIllustrationParameter.setBackdateddate(caseLevelAttributes.get("BACKDATED_DATE"));
        counterofferAndIllustrationParameter.setEndowmentpremium(caseLevelAttributes.get("")); // New_Tag to be created.
        counterofferAndIllustrationParameter.setAnnuityoption(caseLevelAttributes.get("")); // New_Tag to be created.
        counterofferAndIllustrationParameter.setAnnuitypaymentopt(caseLevelAttributes.get("")); // New_Tag to be created.
        counterofferAndIllustrationParameter.setAnnuitytype(caseLevelAttributes.get("")); // New_Tag to be created.
        counterofferAndIllustrationParameter.setPremmultiple(caseLevelAttributes.get("PREMIUM_MULTIPLE"));
        counterofferAndIllustrationParameter.setSourceoffund(caseLevelAttributes.get("")); // Not given by the SWIFT team
        counterofferAndIllustrationParameter.setExistingcustomer(caseLevelAttributes.get("EXISTING_PMLI_CUSTOMER_FLAG"));
        counterofferAndIllustrationParameter.setCommutingoption(caseLevelAttributes.get("")); // New_Tag to be created.
        counterofferAndIllustrationParameter.setCommutingpercentage(caseLevelAttributes.get("")); // New_Tag to be created.
        counterofferAndIllustrationParameter.setPospflag(caseLevelAttributes.get("POS_FLAG")); // Did not find Posp_Flag at case level, so setting POS_FLAG

        //MTP
        counterofferAndIllustrationParameter.setCoveroption(caseLevelAttributes.get("")); // Not given by the SWIFT team
        counterofferAndIllustrationParameter.setJointlife(caseLevelAttributes.get("")); // Not given by the SWIFT team
        counterofferAndIllustrationParameter.setEducation(caseLevelAttributes.get("")); // EDUCATION_LEVEL for the respective life
        counterofferAndIllustrationParameter.setOccupation(caseLevelAttributes.get("")); // OCCUPATION for the respective life
        counterofferAndIllustrationParameter.setAnnualincome(caseLevelAttributes.get("")); // ANNUAL_GROSS_INCOME_DECLARED (for respective life)
        counterofferAndIllustrationParameter.setOccupationofspouse(caseLevelAttributes.get("")); // OCCUPATION of life2, also need to validate with the AI_TO_ PI_RELATIONSHIP
        counterofferAndIllustrationParameter.setAgeofspouse(caseLevelAttributes.get("")); // AGE of life2,  also need to validate with the AI_TO_ PI_RELATIONSHIP
        counterofferAndIllustrationParameter.setGenderofspouse(caseLevelAttributes.get("")); // Gender of life2,   also need to validate with the AI_TO_ PI_RELATIONSHIP

        //MTS
        counterofferAndIllustrationParameter.setBasicbenefitoption(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setCoverenhancementoption(caseLevelAttributes.get("")); // based on the excel and product coder
        counterofferAndIllustrationParameter.setDobchild(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setCurrentgradeofchild(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setCurrentannualschoolfees(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setReturnofpremium(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setSpousecoverage(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setSpousename(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setDobspouse(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setClassoflivesspouse(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setHealthextra(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setAgeextraspouse(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setSpousecoversumassured(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setMonthlyincomepayout(caseLevelAttributes.get(""));

        //MWC
        counterofferAndIllustrationParameter.setPlanoption(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setFundstrategy(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setFundchoiceprotector2(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setFundchoicebalancer2(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setFundchoiceflexicap(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setFundchoicevirtue2(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setFundchoiceliquidfund(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setFundchoicemultiplier3(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setFundchoicebondopportunitiesfund(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setFundchoicebalancedopportunitiesfund(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setFundchoicemidcapfund(caseLevelAttributes.get(""));

        //MME
        counterofferAndIllustrationParameter.setHealthbenefittype(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setNumberofadults1(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setNumberofadults2(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setDobofadult2(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setDobofadult3(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setDobofadult4(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setDobofadult5(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setDobofadult6(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setNumberofchildren1(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setNumberofchildren2(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setDobofchild1(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setDobofchild2(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setDobofchild3(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setDobofchild4(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setDobofchild5(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setHealthsuminsured(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setNoclaimsbonussuperpremium(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setUnlimitedautomaticrecharge(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setPersonalaccidentcover(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setPersonalaccidentalcoveramount(caseLevelAttributes.get("")); // Yes if (personalaccidentcover) selected as yes
        counterofferAndIllustrationParameter.setOpdcare(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setEmployee(caseLevelAttributes.get(""));
        counterofferAndIllustrationParameter.setCompanyname(caseLevelAttributes.get("")); // Yes if (employee) selected as yes

        return counterofferAndIllustrationParameter;
    }

    public MunichreRequest getLifeLevelAttributes(String caseId,List<Life> lives,
                                                                       MunichreRequest counterofferAndIllustrationParameter){
        LifeAttribute firstLifeAttribute = null;
        LifeAttribute secondLifeAttribute = null;;
        for(Life life : lives){
            if(!("1".equals(life.getLifeInstance()) || "2".equals(life.getLifeInstance())))
                continue;
            else if("1".equals(life.getLifeInstance()))
                firstLifeAttribute = munichRe.getLifeAttributes(caseId, life.getLifeInstance());
            else if("2".equals(life.getLifeInstance()))
                secondLifeAttribute = munichRe.getLifeAttributes(caseId, life.getLifeInstance());
        }

        if(firstLifeAttribute!=null && firstLifeAttribute.getAttributes()!=null) {
            counterofferAndIllustrationParameter.setName(firstLifeAttribute.getAttributes().get("NAME"));
            counterofferAndIllustrationParameter.setGender(firstLifeAttribute.getAttributes().get("GENDER"));  // Life level
            counterofferAndIllustrationParameter.setDob(firstLifeAttribute.getAttributes().get("DATE_OF_BIRTH")); // PO_DATE_OF_BIRTH, DATE_OF_BIRTH in each life

            counterofferAndIllustrationParameter.setClassoflives(firstLifeAttribute.getAttributes().get("SMOKER_STATUS")); // Smoker_Status (If yes "1", No "0")
            counterofferAndIllustrationParameter.setMailaddressstate(firstLifeAttribute.getAttributes().get("STATE")); // STATE for respective life
            counterofferAndIllustrationParameter.setPrimannualincome(firstLifeAttribute.getAttributes().get("ANNUAL_GROSS_INCOME_DECLARED")); // ANNUAL_GROSS_INCOME_DECLARED (for life1)
            counterofferAndIllustrationParameter.setRiderCode(firstLifeAttribute.getAttributes().get("COVERAGE_CODE"));
            counterofferAndIllustrationParameter.setAdbRiderCode(firstLifeAttribute.getAttributes().get("RISK_TYPE_ADB_COVERAGE_CODES"));
            counterofferAndIllustrationParameter.setCeoRiderCode(firstLifeAttribute.getAttributes().get("RISK_TYPE_CEO_COVERAGE_CODES"));
            counterofferAndIllustrationParameter.setCiRiderCode(firstLifeAttribute.getAttributes().get("RISK_TYPE_CI_COVERAGE_CODES"));
            counterofferAndIllustrationParameter.setSiRiderCode(firstLifeAttribute.getAttributes().get("RISK_TYPE_SI_COVERAGE_CODES"));
            counterofferAndIllustrationParameter.setTpdRiderCode(firstLifeAttribute.getAttributes().get("RISK_TYPE_TPD_COVERAGE_CODES"));
            counterofferAndIllustrationParameter.setWpciRiderCode(firstLifeAttribute.getAttributes().get("RISK_TYPE_WPCI_COVERAGE_CODES"));
            counterofferAndIllustrationParameter.setAdbRiderSumAssured(firstLifeAttribute.getRiskBasedAttributes().getFACE_AMOUNT().get("ADB"));
            counterofferAndIllustrationParameter.setCeoRiderSumAssured(firstLifeAttribute.getRiskBasedAttributes().getFACE_AMOUNT().get("CEO"));
            counterofferAndIllustrationParameter.setCiRiderSumAssured(firstLifeAttribute.getRiskBasedAttributes().getFACE_AMOUNT().get("CI"));
            counterofferAndIllustrationParameter.setSiRiderSumAssured(firstLifeAttribute.getRiskBasedAttributes().getFACE_AMOUNT().get("SI"));
            counterofferAndIllustrationParameter.setTpdRiderSumAssured(firstLifeAttribute.getRiskBasedAttributes().getFACE_AMOUNT().get("TPD"));
            counterofferAndIllustrationParameter.setWpciRiderSumAssured(firstLifeAttribute.getRiskBasedAttributes().getFACE_AMOUNT().get("WPCI"));

            //MTP
            counterofferAndIllustrationParameter.setEducation(firstLifeAttribute.getAttributes().get("EDUCATION_LEVEL")); // EDUCATION_LEVEL for the respective life
            counterofferAndIllustrationParameter.setOccupation(firstLifeAttribute.getAttributes().get("OCCUPATION")); // OCCUPATION for the respective life
            counterofferAndIllustrationParameter.setAnnualincome(firstLifeAttribute.getAttributes().get("ANNUAL_GROSS_INCOME_DECLARED")); // ANNUAL_GROSS_INCOME_DECLARED (for respective life)
            counterofferAndIllustrationParameter.setPrimaryLifeCoverageCode(firstLifeAttribute.getAttributes().get("RISK_TYPE_LIFE_COVERAGE_CODES"));
        }
        if(firstLifeAttribute!=null && firstLifeAttribute.getRiskBasedAttributes()!=null) {
            counterofferAndIllustrationParameter.setFaceamount(firstLifeAttribute.getRiskBasedAttributes().getFACE_AMOUNT().get("LIFE")); // Life level
            counterofferAndIllustrationParameter.setChildName(firstLifeAttribute.getAttributes().get("NAME"));
            counterofferAndIllustrationParameter.setChildDob(firstLifeAttribute.getAttributes().get("DATE_OF_BIRTH"));
            counterofferAndIllustrationParameter.setChildGender(firstLifeAttribute.getAttributes().get("GENDER"));
        }

        if(secondLifeAttribute!=null && secondLifeAttribute.getAttributes()!=null) {
            counterofferAndIllustrationParameter.setSecannudobinfo(secondLifeAttribute.getAttributes().get("DATE_OF_BIRTH"));
            counterofferAndIllustrationParameter.setSecondaryincomesource(secondLifeAttribute.getAttributes().get("OCCUPATION")); // OCCUPATION for the secondary life

            //MTP
            counterofferAndIllustrationParameter.setOccupationofspouse(secondLifeAttribute.getAttributes().get("OCCUPATION")); // OCCUPATION of life2, also need to validate with the AI_TO_ PI_RELATIONSHIP
            counterofferAndIllustrationParameter.setAgeofspouse(secondLifeAttribute.getAttributes().get("AGE")); // AGE of life2,  also need to validate with the AI_TO_ PI_RELATIONSHIP
            counterofferAndIllustrationParameter.setGenderofspouse(secondLifeAttribute.getAttributes().get("GENDER")); // Gender of life2,   also need to validate with the AI_TO_ PI_RELATIONSHIP
        }

        if(secondLifeAttribute!=null && secondLifeAttribute.getRiskBasedAttributes()!=null) {
            counterofferAndIllustrationParameter.setSecondaryfaceamount(secondLifeAttribute.getRiskBasedAttributes().getFACE_AMOUNT().get("LIFE")); //FACE_AMOUNT for the second life
        }
        return counterofferAndIllustrationParameter;
    }

    public MunichreRequest setTheParametersComingFromSwift(MunichreRequest parameters,String caseId){
        Optional<NvestRequiredParameter> optional = nvestParametersRepo.findByCaseId(caseId);
        if(optional.isPresent()){
            NvestRequiredParameter paramFromSwift = optional.get();

            parameters.setAgeextraspouse(paramFromSwift.getAgeextraspouse());
            parameters.setAnnuityoption(paramFromSwift.getAnnuityoption());
            parameters.setAnnuitypaymentopt(paramFromSwift.getAnnuitypaymentopt());
            parameters.setAnnuitytype(paramFromSwift.getAnnuitytype());
            parameters.setBasicbenefitoption(paramFromSwift.getBasicbenefitoption());
            parameters.setBonusoption(paramFromSwift.getBonusoption());
            parameters.setClassoflivesspouse(paramFromSwift.getClassoflivesspouse());
            parameters.setCommutingoption(paramFromSwift.getCommutingoption());
            parameters.setCommutingpercentage(paramFromSwift.getCommutingpercentage());
            parameters.setCompanyname(paramFromSwift.getCompanyname());
            parameters.setCoverenhancementoption(paramFromSwift.getCoverenhancementoption());
            parameters.setCoveroption(paramFromSwift.getCoveroption());
            parameters.setCurrentannualschoolfees(paramFromSwift.getCurrentannualschoolfees());
            parameters.setCurrentgradeofchild(paramFromSwift.getCurrentgradeofchild());
            try {
                parameters.setDefermentperiod(calculateDefermentPeriod(parameters, paramFromSwift.getDefermentperiod()));
            }catch(Exception e){
                logger.error("Exception While calculating DefermentPeriod :: caseId :: ["+caseId+"] :: ",e);
            }
            parameters.setDobchild(paramFromSwift.getDobchild());
            parameters.setDobofadult2(paramFromSwift.getDobofadult2());
            parameters.setDobofadult3(paramFromSwift.getDobofadult3());
            parameters.setDobofadult4(paramFromSwift.getDobofadult4());
            parameters.setDobofadult5(paramFromSwift.getDobofadult5());
            parameters.setDobofadult6(paramFromSwift.getDobofadult6());
            parameters.setDobofchild1(paramFromSwift.getDobofchild1());
            parameters.setDobofchild2(paramFromSwift.getDobofchild2());
            parameters.setDobofchild3(paramFromSwift.getDobofchild3());
            parameters.setDobofchild4(paramFromSwift.getDobofchild4());
            parameters.setDobofchild5(paramFromSwift.getDobofchild5());
            parameters.setDobspouse(paramFromSwift.getDobspouse());
            parameters.setEmployee(paramFromSwift.getEmployee());
            parameters.setEndowmentpremium(paramFromSwift.getEndowmentpremium());
            parameters.setFamilycarebenefit(paramFromSwift.getFamilycarebenefit());
            parameters.setFundchoicebalancedopportunitiesfund(paramFromSwift.getFundchoicebalancedopportunitiesfund());
            parameters.setFundchoicebalancer2(paramFromSwift.getFundchoicebalancer2());
            parameters.setFundchoicebondopportunitiesfund(paramFromSwift.getFundchoicebondopportunitiesfund());
            parameters.setSustainableEquityFund(paramFromSwift.getSustainableEquityFund());
            parameters.setIndiaOpportunitiesFund(paramFromSwift.getIndiaOpportunitiesFund());
            parameters.setFundchoiceflexicap(paramFromSwift.getFundchoiceflexicap());
            parameters.setFundchoiceliquidfund(paramFromSwift.getFundchoiceliquidfund());
            parameters.setFundchoicemidcapfund(paramFromSwift.getFundchoicemidcapfund());
            parameters.setFundchoicemultiplier3(paramFromSwift.getFundchoicemultiplier3());
            parameters.setFundchoiceprotector2(paramFromSwift.getFundchoiceprotector2());
            parameters.setFundchoicevirtue2(paramFromSwift.getFundchoicevirtue2());
            parameters.setFundstrategy(paramFromSwift.getFundstrategy());
            parameters.setHealthbenefittype(paramFromSwift.getHealthbenefittype());
            parameters.setHealthextra(paramFromSwift.getHealthextra());
            parameters.setHealthsuminsured(paramFromSwift.getHealthsuminsured());
            parameters.setIncomepayoutoption(paramFromSwift.getIncomepayoutoption());
            parameters.setIsstdriderval(paramFromSwift.getIsstdriderval());
            parameters.setMonthlyincomepayout(paramFromSwift.getMonthlyincomepayout());
            parameters.setNoclaimsbonussuperpremium(paramFromSwift.getNoclaimsbonussuperpremium());
            parameters.setNumberofadults1(paramFromSwift.getNumberofadults1());
            parameters.setNumberofadults2(paramFromSwift.getNumberofadults2());
            parameters.setNumberofchildren1(paramFromSwift.getNumberofchildren1());
            parameters.setNumberofchildren2(paramFromSwift.getNumberofchildren2());
            parameters.setOpdcare(paramFromSwift.getOpdcare());
            parameters.setPersonalaccidentalcoveramount(paramFromSwift.getPersonalaccidentalcoveramount());
            parameters.setPersonalaccidentcover(paramFromSwift.getPersonalaccidentcover());
            parameters.setPlanoption(paramFromSwift.getPlanoption());
            parameters.setProductoption(paramFromSwift.getProductoption());
            parameters.setReturnofpremium(paramFromSwift.getReturnofpremium());
            parameters.setSaMultiple(paramFromSwift.getSaMultiple());
            parameters.setSourceoffund(paramFromSwift.getSourceoffund());
            parameters.setSpousecoverage(paramFromSwift.getSpousecoverage());
            parameters.setSpousecoversumassured(paramFromSwift.getSpousecoversumassured());
            parameters.setSpousename(paramFromSwift.getSpousename());
            parameters.setUnlimitedautomaticrecharge(paramFromSwift.getUnlimitedautomaticrecharge());
            parameters.setBenefitoption(paramFromSwift.getBenefitoption());
            parameters.setMonthlyincome(paramFromSwift.getMonthlyincomepayout());
            parameters.setDeathbenefitoption(paramFromSwift.getDeathbenefitoption());
        }
        return parameters;
    }

    public String calculateDefermentPeriod(MunichreRequest parameters,String defermentPeriodFromDb) {
        if((defermentPeriodFromDb==null || "".equals(defermentPeriodFromDb))
                && (parameters.getPolicyterm()!=null && !"".equals(parameters.getPolicyterm()))
                && (parameters.getPremiumpayterm()!=null && !"".equals(parameters.getPremiumpayterm()))){
            double dividend = Double.parseDouble(parameters.getPolicyterm());
            double divisor = Double.parseDouble(parameters.getPremiumpayterm());
            double quotient = dividend/divisor;
            double solidQuotient = getSolidQuotient(quotient);
            double reminder = dividend - (divisor * solidQuotient);
            int rem = (int)reminder;
            if(rem==1 || rem==2)
                return ""+rem;
            else
                return ""+0;
        }else{
            return defermentPeriodFromDb;
        }
    }

    public double getSolidQuotient(double quotient){
        String originalQuotient = String.valueOf(quotient).replace(".","_");
        String[] str = originalQuotient.split("_");
        return Double.parseDouble(str[0]);
    }

}

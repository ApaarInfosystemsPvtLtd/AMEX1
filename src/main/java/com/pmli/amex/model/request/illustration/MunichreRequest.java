package com.pmli.amex.model.request.illustration;

import lombok.*;

@Data
@NoArgsConstructor
public class MunichreRequest {

    private String uniquekey="";
    private String name="";
    private String formtype="";
    private String productcode="";
    private String gender="";
    private String secannudobinfo="";
    private String metsmartpremium="";
    private String metsmartmultiple="";
    private String faceamount="";
    private String policyterm="";
    private String premiumpayterm="";
    private String premiumpayfreq="";
    private String dob="";
    private String renewalpaymode="";
    private String productoption="";
    private String paymentoption="";
    private String familycarebenefit="";
    private String benefitoption="";
    private String monthlyincome="";
    private String secondaryfaceamount="";
    private String secondaryincomesource="";
    private String lifepartner="";
    private String classoflives="";
    private String mailaddressstate="";
    private String saMultiple="";
    private String defermentperiod ="";
    private String bonusoption="";
    private String deathbenefitoption ="";
    private String maturityoption ="";
    private String incomepayoutoption ="";
    private String isstdriderval="";
    private String primannualincome ="";
    private String backdateddate="";
    private String endowmentpremium="";
    private String annuityoption="";
    private String annuitypaymentopt="";
    private String annuitytype="";
    private String premmultiple="";
    private String sourceoffund="";
    private String existingcustomer="";
    private String commutingoption="";
    private String commutingpercentage="";
    private String pospflag="";
    private String primaryLifeCoverageCode="";
    private String prChannel;

    /*Added for Missing 4 products.*/

    //MTP
    private String coveroption="";
    private String jointlife="";
    private String education="";
    private String occupation="";
    private String annualincome="";
    private String occupationofspouse="";
    private String ageofspouse ="";
    private String genderofspouse="";

    //MTS
    private String basicbenefitoption="";
    private String coverenhancementoption="";
    private String dobchild="";
    private String currentgradeofchild="";
    private String currentannualschoolfees="";
    private String returnofpremium="";
    private String spousecoverage="";
    private String spousename="";
    private String dobspouse="";
    private String classoflivesspouse="";
    private String healthextra="";
    private String ageextraspouse="";
    private String spousecoversumassured="";
    private String monthlyincomepayout="";

    //MWC
    private String planoption="";
    private String fundstrategy="";
    private String fundchoiceprotector2="";
    private String fundchoicebalancer2="";
    private String fundchoiceflexicap="";
    private String fundchoicevirtue2="";
    private String fundchoiceliquidfund="";
    private String fundchoicemultiplier3="";
    private String fundchoicebondopportunitiesfund="";
    private String fundchoicebalancedopportunitiesfund="";
    private String fundchoicepremiermultiCapfund ="";
    private String fundchoicemidcapfund="";
    private String fundchoicecrestThematicFund ="";
    private String sustainableEquityFund="";
    private String indiaOpportunitiesFund="";

    //MME
    private String healthbenefittype="";
    private String numberofadults1 ="";
    private String numberofadults2 ="";
    private String dobofadult2="";
    private String dobofadult3="";
    private String dobofadult4="";
    private String dobofadult5="";
    private String dobofadult6="";
    private String numberofchildren1 ="";
    private String numberofchildren2 ="";
    private String dobofchild1="";
    private String dobofchild2="";
    private String dobofchild3="";
    private String dobofchild4="";
    private String dobofchild5="";
    private String healthsuminsured="";
    private String noclaimsbonussuperpremium="";
    private String unlimitedautomaticrecharge="";
    private String personalaccidentcover="";
    private String personalaccidentalcoveramount="";
    private String opdcare="";
    private String employee="";
    private String companyname="";

    //GGP
    private String additionalBenefit;

    //Rider Code
    private String riderCode="";
    private String adbRiderCode="";
    private String ceoRiderCode="";
    private String ciRiderCode="";
    private String lifeRiderCode="";
    private String siRiderCode="";
    private String tpdRiderCode="";
    private String wpciRiderCode="";

    private String riderSumAssured="";
    private String adbRiderSumAssured="";
    private String ceoRiderSumAssured="";
    private String ciRiderSumAssured="";
    private String lifeRiderSumAssured="";
    private String siRiderSumAssured="";
    private String tpdRiderSumAssured="";
    private String wpciRiderSumAssured="";

    //GEN
    private String desiredIncome="0";
    private String incomepayoutPeriod="";
    private String childDetails="";
    private String childName="";
    private String childDob="";
    private String childGender="";
}

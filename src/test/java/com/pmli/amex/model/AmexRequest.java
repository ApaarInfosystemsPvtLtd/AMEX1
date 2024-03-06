package com.pmli.amex.model;

import com.pmli.amex.model.request.filenet.DocumentDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AmexRequest {

    public List<String> getApplicationList_Request(){
        List<String> applicationList = new ArrayList<>();
        applicationList.add("379957960");
        return applicationList;
    }

    public String getApplicationList(){
       return "[\n" +
               "    \"379957960\",\n" +
               "    \"107150760\",\n" +
               "    \"146660823\",\n" +
               "    \"431126569\",\n" +
               "    \"473891298\"\n" +
               "]";
    }

    public String nvestRequest(){
        return "{\n" +
                "    \"uniquekey\": \"719405177\",\n" +
                "    \"name\": \"Hdh Bdb\",\n" +
                "    \"formtype\": \"\",\n" +
                "    \"productcode\": \"MAS\",\n" +
                "    \"gender\": \"M\",\n" +
                "    \"secannudobinfo\": \"\",\n" +
                "    \"metsmartpremium\": \"7018\",\n" +
                "    \"metsmartmultiple\": \"\",\n" +
                "    \"faceamount\": \"2900000\",\n" +
                "    \"policyterm\": \"15\",\n" +
                "    \"premiumpayterm\": \"10\",\n" +
                "    \"premiumpayfreq\": \"A\",\n" +
                "    \"dob\": \"1993-12-12\",\n" +
                "    \"renewalpaymode\": \"C\",\n" +
                "    \"productoption\": \"C\",\n" +
                "    \"paymentoption\": \"LP10\",\n" +
                "    \"familycarebenefit\": \"\",\n" +
                "    \"benefitoption\": \"1\",\n" +
                "    \"monthlyincome\": \"\",\n" +
                "    \"secondaryfaceamount\": \"\",\n" +
                "    \"secondaryincomesource\": \"\",\n" +
                "    \"lifepartner\": \"\",\n" +
                "    \"classoflives\": \"NO\",\n" +
                "    \"mailaddressstate\": \"\",\n" +
                "    \"saMultiple\": \"\",\n" +
                "    \"defermentperiod\": \"0\",\n" +
                "    \"bonusoption\": \"\",\n" +
                "    \"deathbenefitoption\": \"\",\n" +
                "    \"maturityoption\": \"\",\n" +
                "    \"incomepayoutoption\": \"\",\n" +
                "    \"isstdriderval\": \"\",\n" +
                "    \"primannualincome\": \"500000\",\n" +
                "    \"backdateddate\": \"\",\n" +
                "    \"endowmentpremium\": \"\",\n" +
                "    \"annuityoption\": \"\",\n" +
                "    \"annuitypaymentopt\": \"\",\n" +
                "    \"annuitytype\": \"\",\n" +
                "    \"premmultiple\": \"\",\n" +
                "    \"sourceoffund\": \"\",\n" +
                "    \"existingcustomer\": \"false\",\n" +
                "    \"commutingoption\": \"\",\n" +
                "    \"commutingpercentage\": \"\",\n" +
                "    \"pospflag\": \"false\",\n" +
                "    \"primaryLifeCoverageCode\": \"MAFL\",\n" +
                "    \"coveroption\": \"\",\n" +
                "    \"jointlife\": \"\",\n" +
                "    \"education\": \"M2\",\n" +
                "    \"occupation\": \"O-01\",\n" +
                "    \"annualincome\": \"500000\",\n" +
                "    \"occupationofspouse\": \"\",\n" +
                "    \"ageofspouse\": \"\",\n" +
                "    \"genderofspouse\": \"\",\n" +
                "    \"basicbenefitoption\": \"MAS\",\n" +
                "    \"coverenhancementoption\": \"\",\n" +
                "    \"dobchild\": \"\",\n" +
                "    \"currentgradeofchild\": \"\",\n" +
                "    \"currentannualschoolfees\": \"\",\n" +
                "    \"returnofpremium\": \"MAS\",\n" +
                "    \"spousecoverage\": \"\",\n" +
                "    \"spousename\": \"\",\n" +
                "    \"dobspouse\": \"\",\n" +
                "    \"classoflivesspouse\": \"Non Smoker\",\n" +
                "    \"healthextra\": \"\",\n" +
                "    \"ageextraspouse\": \"\",\n" +
                "    \"spousecoversumassured\": \"\",\n" +
                "    \"monthlyincomepayout\": \"\",\n" +
                "    \"planoption\": \"\",\n" +
                "    \"fundstrategy\": \"1\",\n" +
                "    \"fundchoiceprotector2\": \"0\",\n" +
                "    \"fundchoicebalancer2\": \"0\",\n" +
                "    \"fundchoiceflexicap\": \"0\",\n" +
                "    \"fundchoicevirtue2\": \"0\",\n" +
                "    \"fundchoiceliquidfund\": \"0\",\n" +
                "    \"fundchoicemultiplier3\": \"0\",\n" +
                "    \"fundchoicebondopportunitiesfund\": \"0\",\n" +
                "    \"fundchoicebalancedopportunitiesfund\": \"0\",\n" +
                "    \"fundchoicepremiermultiCapfund\": \"\",\n" +
                "    \"fundchoicemidcapfund\": \"0\",\n" +
                "    \"fundchoicecrestThematicFund\": \"\",\n" +
                "    \"sustainableEquityFund\": \"0\",\n" +
                "    \"indiaOpportunitiesFund\": \"0\",\n" +
                "    \"healthbenefittype\": \"\",\n" +
                "    \"numberofadults1\": \"\",\n" +
                "    \"numberofadults2\": \"\",\n" +
                "    \"dobofadult2\": \"\",\n" +
                "    \"dobofadult3\": \"\",\n" +
                "    \"dobofadult4\": \"\",\n" +
                "    \"dobofadult5\": \"\",\n" +
                "    \"dobofadult6\": \"\",\n" +
                "    \"numberofchildren1\": \"\",\n" +
                "    \"numberofchildren2\": \"\",\n" +
                "    \"dobofchild1\": \"\",\n" +
                "    \"dobofchild2\": \"\",\n" +
                "    \"dobofchild3\": \"\",\n" +
                "    \"dobofchild4\": \"\",\n" +
                "    \"dobofchild5\": \"\",\n" +
                "    \"healthsuminsured\": \"\",\n" +
                "    \"noclaimsbonussuperpremium\": \"\",\n" +
                "    \"unlimitedautomaticrecharge\": \"\",\n" +
                "    \"personalaccidentcover\": \"\",\n" +
                "    \"personalaccidentalcoveramount\": \"\",\n" +
                "    \"opdcare\": \"\",\n" +
                "    \"employee\": \"No\",\n" +
                "    \"companyname\": \"\",\n" +
                "    \"riderCode\": \"MAFL\",\n" +
                "    \"adbRiderCode\": \"\",\n" +
                "    \"ceoRiderCode\": \"\",\n" +
                "    \"ciRiderCode\": \"\",\n" +
                "    \"lifeRiderCode\": \"\",\n" +
                "    \"siRiderCode\": \"\",\n" +
                "    \"tpdRiderCode\": \"\",\n" +
                "    \"wpciRiderCode\": \"\",\n" +
                "    \"riderSumAssured\": \"\",\n" +
                "    \"adbRiderSumAssured\": \"\",\n" +
                "    \"ceoRiderSumAssured\": \"\",\n" +
                "    \"ciRiderSumAssured\": \"\",\n" +
                "    \"lifeRiderSumAssured\": \"\",\n" +
                "    \"siRiderSumAssured\": \"\",\n" +
                "    \"tpdRiderSumAssured\": \"\",\n" +
                "    \"wpciRiderSumAssured\": \"\",\n" +
                "    \"desiredIncome\": \"0\",\n" +
                "    \"incomepayoutPeriod\": \"\",\n" +
                "    \"childDetails\": \"\",\n" +
                "    \"childName\": \"Hdh Bdb\",\n" +
                "    \"childDob\": \"1993-12-12\",\n" +
                "    \"childGender\": \"M\"\n" +
                "}";
    }

    public String filenetUploadRequest(){
        return "{\n" +
                "    \"applicationNumber\":\"123456789\",\n" +
                "    \"fileContent\":\"JVBERi0xLjQKMSAwIG9iago8PAovVGl0bGUgKP7\\u003d\\u003d\"\n" +
                "}";
    }

    public DocumentDTO documentDTO (){
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setApplicationNumber("123456789");
        documentDTO.setFileContent("JVBERi0xLjQKMSAwIG9iago8PAovVGl0bGUgKP7\\u003d\\u003d");
        return documentDTO;
    }
}

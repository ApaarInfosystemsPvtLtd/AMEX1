package com.pmli.amex.model.request.db;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document("NvestRequiredParameter")
public class NvestRequiredParameter {

    private String id;
    private String caseId;
    private LocalDateTime createdDateTime;
    private String ageextraspouse = "";
    private String annuityoption = "";
    private String annuitypaymentopt = "";
    private String annuitytype = "";
    private String basicbenefitoption = "";
    private String bonusoption = "";
    private String classoflivesspouse = "";
    private String commutingoption = "";
    private String commutingpercentage = "";
    private String companyname = "";
    private String coverenhancementoption = "";
    private String coveroption = "";
    private String currentannualschoolfees = "";
    private String currentgradeofchild = "";
    private String defermentperiod = "";
    private String dobchild = "";
    private String dobofadult2 = "";
    private String dobofadult3 = "";
    private String dobofadult4 = "";
    private String dobofadult5 = "";
    private String dobofadult6 = "";
    private String dobofchild1 = "";
    private String dobofchild2 = "";
    private String dobofchild3 = "";
    private String dobofchild4 = "";
    private String dobofchild5 = "";
    private String dobspouse = "";
    private String employee = "";
    private String endowmentpremium = "";
    private String familycarebenefit = "";
    private String fundchoicebalancedopportunitiesfund = "";
    private String fundchoicebalancer2 = "";
    private String fundchoicebondopportunitiesfund = "";
    private String fundchoicecrest_thematic_fund = "";
    private String fundchoiceflexicap = "";
    private String fundchoiceliquidfund = "";
    private String fundchoicemidcapfund = "";
    private String fundchoicemultiplier3 = "";
    private String fundchoicepremiermulti_capfund = "";
    private String fundchoiceprotector2 = "";
    private String fundchoicevirtue2 = "";
    private String fundstrategy = "";
    private String healthbenefittype = "";
    private String healthextra = "";
    private String healthsuminsured = "";
    private String incomepayoutoption = "";
    private String isstdriderval = "";
    private String monthlyincomepayout = "";
    private String noclaimsbonussuperpremium = "";
    private String numberofadults1 = "";
    private String numberofadults2 = "";
    private String numberofchildren1 = "";
    private String numberofchildren2 = "";
    private String opdcare = "";
    private String personalaccidentalcoveramount = "";
    private String personalaccidentcover = "";
    private String planoption = "";
    private String productoption = "";
    private String returnofpremium = "";
    private String saMultiple = "";
    private String sourceoffund = "";
    private String spousecoverage = "";
    private String spousecoversumassured = "";
    private String spousename = "";
    private String unlimitedautomaticrecharge = "";
    private String benefitoption = "";
    private String deathbenefitoption = "";
    private String monthlyIncome = "";
    private String sustainableEquityFund="";
    private String indiaOpportunitiesFund="";
}

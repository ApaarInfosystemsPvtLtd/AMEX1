package com.pmli.amex.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RetailUploadSubmissionDB {

    RETAIL_ID ("RETAIL_ID"),
    APPLICATIONNUMBER ("APPLICATIONNUMBER"),
    ISBIPDFGENERATED ("ISBIPDFGENERATED"),
    ISIFPINITIATED ("ISIFPINITIATED"),
    CREATEDDATE ("CREATEDDATE");

    private final String Key;
}

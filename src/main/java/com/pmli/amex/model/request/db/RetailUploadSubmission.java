package com.pmli.amex.model.request.db;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class RetailUploadSubmission {

    private String RETAIL_ID = "";
    private String APPLICATIONNUMBER = "";
    private String ISBIPDFGENERATED = "";
    private String ISIFPINITIATED = "";
    private String CREATEDDATE = "";
    private String isBiDocumentUploaded = "N";
}

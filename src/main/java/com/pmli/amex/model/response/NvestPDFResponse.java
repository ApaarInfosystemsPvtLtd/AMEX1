package com.pmli.amex.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class NvestPDFResponse {

    private String Status;
    private String dataString;
    private String remarks;
}

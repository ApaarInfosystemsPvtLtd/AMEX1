package com.pmli.amex.model.log;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BiPDF {

    private String quoteId;
    private String biPdfResponse=null;
    private String biStatus;
}

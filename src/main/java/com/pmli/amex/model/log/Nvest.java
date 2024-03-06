package com.pmli.amex.model.log;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Nvest {

    private String munichreRequest;
    private String illustrationResponse;
    private BiPDF biPDF;
    private String nvestStatus=null;
}

package com.pmli.amex.model.response.munichre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Links {
    private String rel;
    private String href;
}

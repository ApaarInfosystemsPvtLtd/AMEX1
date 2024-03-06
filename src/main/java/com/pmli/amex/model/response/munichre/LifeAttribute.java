package com.pmli.amex.model.response.munichre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode
@ToString
public class LifeAttribute {
    private Map<String, String> attributes;
    private RiskBasedAttributes riskBasedAttributes;
    private List<Links> links;
}

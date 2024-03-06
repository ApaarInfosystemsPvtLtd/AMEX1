package com.pmli.amex.model.response.munichre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Map;

@Data
@EqualsAndHashCode
@ToString
public class UpdateCaseAttributesResponse {
    private ArrayList<Map<String,String>> _links;
    private Map<String,String> attributes;
}


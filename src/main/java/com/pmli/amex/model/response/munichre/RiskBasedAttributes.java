package com.pmli.amex.model.response.munichre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode
@ToString
public class RiskBasedAttributes {

    Map<String,String> BASE_PRODUCT_FLAG = new HashMap<>();
    Map<String,String> CURRENT_RISK_TYPE = new HashMap<>();
    Map<String,String> EXCLUSION_COUNT = new HashMap<>();
    Map<String,String> FACE_AMOUNT = new HashMap<>();
    Map<String,String> INCOME_FACTOR = new HashMap<>();
    Map<String,String> ORIGINAL_FACE_AMOUNT = new HashMap<>();
    Map<String,String> POLICY_RISK_TYPE_UW_STATUS = new HashMap<>();
    Map<String,String> TOTAL_FINANCIAL_SUM_UNDER_CONSIDERATION = new HashMap<>();
    Map<String,String> TOTAL_MEDICAL_SUM_UNDER_CONSIDERATION = new HashMap<>();
    Map<String,String> TOTAL_NEGATIVE_PREMIUM_LOADING = new HashMap<>();
    Map<String,String> TOTAL_PREMIUM_LOADING = new HashMap<>();
    Map<String,String> TOTAL_SUM_ASSURED_LOADING = new HashMap<>();
}

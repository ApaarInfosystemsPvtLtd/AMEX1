package com.pmli.amex.model.response.filenet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TokenGenerationResponse {
    private String accessToken;
}

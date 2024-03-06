package com.pmli.amex.model.response.munichre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode
@ToString
public class CreatedLives {
    private List<Life> content;
}

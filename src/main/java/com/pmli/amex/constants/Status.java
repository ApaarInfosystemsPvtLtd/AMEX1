package com.pmli.amex.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    SUCCESS ("SUCCESS"),
    FAILURE ("FAILED");

    private final String key;
}


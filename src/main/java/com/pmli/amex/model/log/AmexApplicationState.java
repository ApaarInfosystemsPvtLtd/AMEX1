package com.pmli.amex.model.log;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Component("AmexApplicationState")
public class AmexApplicationState {

    private String applicationNumber;
    private Nvest nvest;
    private FilenetUpload filenetUpload;
    private String status;
    private String createdDate = String.valueOf(LocalDate.now());
    private LocalDateTime createdDateTime =  LocalDateTime.now();

}

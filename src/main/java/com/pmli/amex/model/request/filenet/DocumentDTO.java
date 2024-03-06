package com.pmli.amex.model.request.filenet;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DocumentDTO {
    private String applicationNumber;
    private String fileContent;
    private String createDate = LocalDateTime.now().toString();

    @Override
    public String toString() {
        return "DocumentDTO{" +
                "applicationNumber='" + applicationNumber + '\'' +
                ", fileContent='" + getFileContentMessage(fileContent) + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

    private String getFileContentMessage(String documentContent){
        String message;
        if(documentContent!= null){
            message= "Data Exist";
        }else {
            message= "Data Is NOT Present";
        }
        return message;
    }
}

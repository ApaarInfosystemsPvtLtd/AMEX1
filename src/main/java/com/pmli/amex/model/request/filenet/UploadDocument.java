package com.pmli.amex.model.request.filenet;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UploadDocument {
    private String loginId;
    private int loginType;
    private String clientId;
    private String applicationNo;
    private String documentClass;
    private String documentTitle;
    private String documentContent;
    private String documentScope;

    @Override
    public String toString() {
        return "UploadDocument{" +
                "loginId='" + loginId + '\'' +
                ", loginType=" + loginType +
                ", clientId='" + clientId + '\'' +
                ", applicationNo='" + applicationNo + '\'' +
                ", documentClass='" + documentClass + '\'' +
                ", documentTitle='" + documentTitle + '\'' +
                ", documentContent='" + getFileContentMessage(documentContent) + '\'' +
                ", documentScope='" + documentScope + '\'' +
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

package com.pmli.amex.model.log;

import com.pmli.amex.model.request.filenet.DocumentDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FilenetUpload {

    private DocumentDTO documentDTO;
    private String filenetRequest;
    private String filenetResponse;
    private String filenetUploadMessage;
    private String filenetUploadStatus=null;
}

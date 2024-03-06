package com.pmli.amex.service;

import com.pmli.amex.model.log.FilenetUpload;
import com.pmli.amex.model.request.filenet.DocumentDTO;
import com.pmli.amex.model.response.filenet.DocumentUploadResponse;
import org.springframework.stereotype.Component;

@Component
public interface FilenetUploadService {
    DocumentUploadResponse documentUpload(DocumentDTO documentDTO, FilenetUpload filenetUpload);
    DocumentUploadResponse documentUpload(DocumentDTO documentDTO);
}

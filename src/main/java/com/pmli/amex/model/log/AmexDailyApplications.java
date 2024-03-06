package com.pmli.amex.model.log;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@Document("AmexDailyApplications")
public class AmexDailyApplications {

    private String processedDate;
    private LocalDateTime processedDateTime;
    private List<String> processingApplicationList;
    private String processStage;
}

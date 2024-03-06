package com.pmli.amex.repo;

import com.pmli.amex.model.log.AmexDailyApplications;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmexDailyApplicationsRepo extends MongoRepository<AmexDailyApplications,String> {
}

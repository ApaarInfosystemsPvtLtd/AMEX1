package com.pmli.amex.repo;

import com.pmli.amex.model.log.AmexApplicationState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmexApplicationStateRepo extends MongoRepository<AmexApplicationState,String> {
}

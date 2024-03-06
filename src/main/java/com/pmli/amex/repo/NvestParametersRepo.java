package com.pmli.amex.repo;

import com.pmli.amex.model.request.db.NvestRequiredParameter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface NvestParametersRepo extends MongoRepository<NvestRequiredParameter,String> {

    Optional<NvestRequiredParameter> findByCaseId(String caseId);
}

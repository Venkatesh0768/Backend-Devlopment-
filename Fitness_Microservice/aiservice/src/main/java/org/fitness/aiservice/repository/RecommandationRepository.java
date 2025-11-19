package org.fitness.aiservice.repository;

import org.fitness.aiservice.model.Recommandation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommandationRepository extends MongoRepository<Recommandation , String> {
    List<Recommandation> findByUserId(String userId);
    Optional<Recommandation> findByActivityId(String activityId);
}

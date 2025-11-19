package org.fitness.aiservice.service;

import org.fitness.aiservice.model.Recommandation;
import org.fitness.aiservice.repository.RecommandationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommandationService {
    private final RecommandationRepository repository;

    public RecommandationService(RecommandationRepository repository) {
        this.repository = repository;
    }


    public List<Recommandation> getUserRecommendation(String userId) {
        return repository.findByUserId(userId);
    }

    public Recommandation getActivityRecommendation(String activityId) {
        return repository.findByActivityId(activityId)
                .orElseThrow(() -> new RuntimeException("No recommendation found for this activity: " + activityId));
    }
}

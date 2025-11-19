package org.fitness.aiservice.controller;

import org.fitness.aiservice.model.Recommandation;
import org.fitness.aiservice.service.RecommandationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommandation")
public class RecommandationController {

    private final RecommandationService recommandationService;


    public RecommandationController(RecommandationService recommandationService) {
        this.recommandationService = recommandationService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommandation>> getUserRecommandation(@PathVariable String userId) {
        return ResponseEntity.ok(recommandationService.getUserRecommendation(userId));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<Recommandation> getActivityRecommandation(@PathVariable String activityId) {
        return ResponseEntity.ok(recommandationService.getActivityRecommendation(activityId));
    }
}

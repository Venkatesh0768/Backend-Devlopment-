package org.fitness.activityservice.controller;

import org.fitness.activityservice.dtos.ActivityRequestDto;
import org.fitness.activityservice.dtos.ActivityResponseDto;
import org.fitness.activityservice.service.ActivityService;
import org.fitness.activityservice.service.ActivityServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    private final ActivityServiceImpl activityService;

    public ActivityController(ActivityServiceImpl activityService) {
        this.activityService = activityService;
    }

    @PostMapping
    public ResponseEntity<ActivityResponseDto> registerActivity(@RequestBody ActivityRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(activityService.registerActivity(requestDto));
    }
}

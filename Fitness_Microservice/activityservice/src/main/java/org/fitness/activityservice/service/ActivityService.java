package org.fitness.activityservice.service;

import org.fitness.activityservice.dtos.ActivityRequestDto;
import org.fitness.activityservice.dtos.ActivityResponseDto;

public interface ActivityService {
    public ActivityResponseDto registerActivity(ActivityRequestDto requestDto);
}

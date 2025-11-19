package org.fitness.activityservice.service;

import org.fitness.activityservice.dtos.ActivityRequestDto;
import org.fitness.activityservice.dtos.ActivityResponseDto;
import org.fitness.activityservice.model.Activity;
import org.fitness.activityservice.repository.ActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService{

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public ActivityResponseDto registerActivity(ActivityRequestDto requestDto) {
        Activity activity = Activity.builder()
                .userId(requestDto.getUserId())
                .type(requestDto.getType())
                .caloriesBurned(requestDto.getCaloriesBurned())
                .startTime(requestDto.getStartTime())
                .additionalMetrics(requestDto.getAdditionalMetrics())
                .build();

        Activity savedActivity = activityRepository.save(activity);
        return mapToDto(savedActivity);
    }

    private ActivityResponseDto mapToDto(Activity savedActivity) {
        return ActivityResponseDto.builder()
                .id(savedActivity.getId())
                .userId(savedActivity.getUserId())
                .type(savedActivity.getType())
                .caloriesBurned(savedActivity.getCaloriesBurned())
                .startTime(savedActivity.getStartTime())
                .additionalMetrics(savedActivity.getAdditionalMetrics())
                .createdAt(savedActivity.getCreatedAt())
                .updatedAt(savedActivity.getUpdatedAt())
                .build();
    }
}

package org.fitness.activityservice.service;

import lombok.extern.slf4j.Slf4j;
import org.fitness.activityservice.dtos.ActivityRequestDto;
import org.fitness.activityservice.dtos.ActivityResponseDto;
import org.fitness.activityservice.model.Activity;
import org.fitness.activityservice.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService{

    private final ActivityRepository activityRepository;
    private final UserValidationService validationService;
    private final KafkaTemplate<String, Activity> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    public ActivityServiceImpl(ActivityRepository activityRepository, UserValidationService validationService, KafkaTemplate<String, Activity> kafkaTemplate) {
        this.activityRepository = activityRepository;
        this.validationService = validationService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public ActivityResponseDto registerActivity(ActivityRequestDto requestDto) {
        Boolean isValidUser = validationService.validateUser(requestDto.getUserId());
        if (!isValidUser){
            throw  new RuntimeException("User is not valid");
        }
        Activity activity = Activity.builder()
                .userId(requestDto.getUserId())
                .type(requestDto.getType())
                .caloriesBurned(requestDto.getCaloriesBurned())
                .startTime(requestDto.getStartTime())
                .additionalMetrics(requestDto.getAdditionalMetrics())
                .createdAt(LocalDateTime.now())
                .build();


        Activity savedActivity = activityRepository.save(activity);

        try {
            kafkaTemplate.send(topicName, activity.getUserId(), savedActivity);
        } catch (Exception e) {
            log.error("Failed to send Kafka message: ", e);
            throw new RuntimeException("Kafka send failed");
        }

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

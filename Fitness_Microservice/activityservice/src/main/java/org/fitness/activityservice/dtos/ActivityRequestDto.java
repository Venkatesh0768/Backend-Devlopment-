package org.fitness.activityservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fitness.activityservice.enums.ActivityType;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityRequestDto {
    private String userId;
    private ActivityType type;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private Map<String , Object> additionalMetrics;
}

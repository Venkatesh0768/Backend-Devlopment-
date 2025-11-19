package org.fitness.aiservice.model;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import jakarta.annotation.sql.DataSourceDefinition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document(collection = "recommandations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recommandation {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private String userId;
    private String activityId;
    private String recommandations;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;

    @CreatedDate
    private LocalDateTime createdAt;

}

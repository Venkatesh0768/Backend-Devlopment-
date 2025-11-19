package org.fitness.activityservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserValidationService {
    private final WebClient userServiceWebClient;

    public UserValidationService(@Qualifier("userServiceWebClient") WebClient userServiceWebClient) {
        this.userServiceWebClient = userServiceWebClient;
    }

    public Boolean validateUser(String id) {
        try {
            return userServiceWebClient.get()
                    .uri("/api/user/{id}/valid", id)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
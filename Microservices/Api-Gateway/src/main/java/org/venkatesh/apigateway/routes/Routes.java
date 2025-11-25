package org.venkatesh.apigateway.routes;


import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> microservice1() {
        return GatewayRouterFunctions.route("microservice1")
                .route(RequestPredicates.path("/get-info"),
                        HandlerFunctions.http())
                .build();
    }

}

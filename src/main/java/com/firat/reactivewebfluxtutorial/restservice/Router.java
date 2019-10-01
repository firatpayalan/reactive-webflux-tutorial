package com.firat.reactivewebfluxtutorial.restservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class Router {
    /**
     * RouterFunctions enables mappin URI mapping with *Handler classes.
     * @param handler
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> route(HelloHandler handler){

        // '/hello' endpoint is binded to HelloHandler.handle method,
        // '/hello' accepts with GET method and also "application/json;charset=UTF-8" content-type.
        // '/hello-text' accepts with GET method and also "text/html" content-type.
        return RouterFunctions
                .route(GET("/hello")
                        .and(accept(MediaType.APPLICATION_JSON_UTF8)),handler::handleWithJSON)

                .andRoute(GET("/hello-text")
                        .and(accept(MediaType.TEXT_HTML)),handler::handleWithText);
    }
}

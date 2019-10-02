package com.firat.reactivewebfluxtutorial.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class PokeapiClient {
    Logger logger = LoggerFactory.getLogger(PokeapiClient.class);

    /**
     *
     * @param pokemonName
     * @return Mono-based stream object, subscribe action must be executed when web service call takes in action.
     */
    public Mono<ClientResponse> pokemon(String pokemonName){
        WebClient build = WebClient.builder()
                .baseUrl("https://pokeapi.co")
                //.filter() is the reactive implementation of web service filter.
                .filter(((request, next) -> {
                    logger.info(">> {} {} {}",request.method(),request.url(),request.headers());
                    return next.exchange(request)
                            .doOnNext(r->{
                                logger.info("<< {} {} {}",r.statusCode().value(), r.statusCode().getReasonPhrase(),r.headers().asHttpHeaders());
                            });
                })).build();

        return build.method(HttpMethod.GET)
                .uri("api/v2/pokemon/" + pokemonName)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .exchange();
    }
}

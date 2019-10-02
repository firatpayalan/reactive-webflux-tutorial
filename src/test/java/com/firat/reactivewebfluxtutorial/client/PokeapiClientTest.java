package com.firat.reactivewebfluxtutorial.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class PokeapiClientTest {

    PokeapiClient client;
    @Before
    public void init(){
        client = new PokeapiClient();
    }

    @Test
    public void pikachu(){

        Mono<String> map = client.pokemon("pikachu")
                .flatMap(i -> i.bodyToMono(JsonNode.class))
                .map(i -> i.get("abilities"))
                .map(i -> i.get(1))
                .map(i -> i.get("ability"))
                .map(i -> i.get("name"))
                .map(JsonNode::asText);

        StepVerifier.create(map)
                .expectNext("static")
                .expectComplete().verify();

    }
}

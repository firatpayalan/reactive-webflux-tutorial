package com.firat.reactivewebfluxtutorial;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class ReactorSamples {
    @Test
    public void createAPublisherAndSubscriberDoesNotRegister(){
        // a Publisher "Flux" has created and takes value "A"
        Flux<String> flux = Flux.just("A");
        // "flux" use map to transform "A" value, however map method creates a new reference.
        flux.map(s -> "foo" + s);
        // System.out.println subscribes into the "flux" publisher but
        // it will print only "A" because the "mapped" value placed in an another reference.
        flux.subscribe(System.out::println);
        // prints A
    }

    @Test
    public void createAPublisherAndSubscriberRegisters(){
        // a Publisher "Flux" has created and takes value "A"
        Flux<String> flux = Flux.just("A");
        // "flux" use map to transform "A" value and register a subscriber with making "chaining"
        // chaining takes the output value of the previous method call with its reference,
        flux.map(s -> "foo" + s).subscribe(System.out::println);
        // prints fooA
    }

    @Test
    public void monoStepVerifer(){
        // StepVerifier can be an assertions of reactive streams.

        // stringMono takes the "Hello World" string as argument
        // then transforms into the "hello world" string through the command of String::toLowerCase
        Mono<String> stringMono = Mono.just("Hello World").map(String::toLowerCase);

        // initial step is the expected output of the .map() method.
        StepVerifier.create(stringMono)
                .expectNext("hello world")
                .expectComplete()
                .verify();


    }


    @Test
    public void fluxStepVerifier(){
        Flux<String> stringFlux = Flux.just("Hello","World").map(String::toLowerCase);

        StepVerifier.create(stringFlux)
                .expectNext("hello")
                .expectNext("world")
                .expectComplete()
                .verify();
    }

}

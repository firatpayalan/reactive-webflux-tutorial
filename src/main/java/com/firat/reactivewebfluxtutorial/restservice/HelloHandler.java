package com.firat.reactivewebfluxtutorial.restservice;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class HelloHandler {

    /**
     * Handler method contains logic part of the http method.
     * @param request ServerRequest is a specific http request implementation object that contains Mono or Flux types.
     * @return a Mono<ServerResponse> object, Mono is a "Publisher" in reactive streams.
     */
    public Mono<ServerResponse> handleWithJSON(ServerRequest request){
        HelloResponse response = new HelloResponse();
        // ServerResponse allows chaining method call.
        // "syncBody" method takes a POJO object. Converts into "Publisher" object
        //  and encodes that specified into the content-type
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).syncBody(response);
    }

    public Mono<ServerResponse> handleWithText(ServerRequest request){
        // ServerResponse allows chaining method call.
        // "syncBody" method takes a POJO object. Converts into "Publisher" object
        //  and encodes that specified into the content-type
        return ServerResponse.ok().contentType(MediaType.TEXT_HTML).syncBody("You' re welcome !");
    }



    class HelloResponse{
        String message = "You' re welcome !";
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

package com.firat.reactivewebfluxtutorial.publishersubscriber;

import org.junit.Test;
import reactor.core.publisher.Mono;

public class PublisherSubscriberTest {

    @Test
    public void publisherSubscriber(){
        Transaction transaction = new Transaction(1,1.25,"AMAZON Payment");

        // Similar as 'Mono.just(transaction)', publisher receives the data
        TransactionPublisher publisher = new TransactionPublisher(transaction);

        //`TransactionSubscriber` contains methods will be executed.
        // The Mono object in WebFlux takes method arguments into its doOnNext, doOnError, doOnSuccess
        TransactionSubscriber subscriber = new TransactionSubscriber();

        // behaves like Mono.just(transaction).subscribe()
        publisher.subscribe(subscriber);
        /**
         * 17:45:32.066 [main] INFO com.firat.reactivewebfluxtutorial.publishersubscriber.TransactionSubscriber - Publisher published the item: Transaction{id=1, amount=1.25, label='AMAZON Payment', status='CREATED'}, main
         * 17:45:32.073 [main] INFO com.firat.reactivewebfluxtutorial.publishersubscriber.TransactionSubscriber - Transaction Processed
         */
    }
}

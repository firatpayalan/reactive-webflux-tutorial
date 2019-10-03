package com.firat.reactivewebfluxtutorial.publishersubscriber;

import org.junit.Test;

public class PublisherSubscriberTest {

    @Test
    public void publisherSubscriber(){
        Transaction transaction = new Transaction(1,1.25,"AMAZON Payment");
        TransactionPublisher publisher = new TransactionPublisher(transaction);
        TransactionSubscriber subscriber = new TransactionSubscriber();

        publisher.subscribe(subscriber);
    }
}

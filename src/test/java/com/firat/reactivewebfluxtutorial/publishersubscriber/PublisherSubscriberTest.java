package com.firat.reactivewebfluxtutorial.publishersubscriber;

import org.junit.Test;

public class PublisherSubscriberTest {

    @Test
    public void publisherSubscriber(){
        Transaction transaction = new Transaction(1,1.25,"AMAZON Payment");
        TransactionPublisher publisher = new TransactionPublisher(transaction);
        TransactionSubscriber subscriber = new TransactionSubscriber();

        publisher.subscribe(subscriber);
        /**
         * 17:45:32.066 [main] INFO com.firat.reactivewebfluxtutorial.publishersubscriber.TransactionSubscriber - Publisher published the item: Transaction{id=1, amount=1.25, label='AMAZON Payment', status='CREATED'}, main
         * 17:45:32.073 [main] INFO com.firat.reactivewebfluxtutorial.publishersubscriber.TransactionSubscriber - Transaction Processed
         */
    }
}

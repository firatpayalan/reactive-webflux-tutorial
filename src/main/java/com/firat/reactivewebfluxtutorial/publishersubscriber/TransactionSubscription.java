package com.firat.reactivewebfluxtutorial.publishersubscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class TransactionSubscription implements Subscription {

    private Subscriber<? super Transaction> transactionSubscriber;

    public TransactionSubscription(Subscriber<? super Transaction> transactionSubscriber) {
        this.transactionSubscriber = transactionSubscriber;
    }

    @Override
    public void request(long n) {

    }

    @Override
    public void cancel() {

    }
}

package com.firat.reactivewebfluxtutorial.publishersubscriber;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class TransactionPublisher implements Publisher<Transaction> {

    private Transaction transaction;

    public TransactionPublisher(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void subscribe(Subscriber<? super Transaction> s) {
        s.onNext(transaction);
        s.onComplete();
    }
}

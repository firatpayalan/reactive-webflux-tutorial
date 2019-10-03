package com.firat.reactivewebfluxtutorial.publishersubscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionSubscriber implements Subscriber<Transaction> {
    Logger logger = LoggerFactory.getLogger(TransactionSubscriber.class);

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
//        this.subscription.request(1);
    }

    @Override
    public void onNext(Transaction transaction) {
        logger.info("Publisher published the item: {}, {}",transaction.toString(),Thread.currentThread().getName());
//        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        logger.error("",t);
    }

    @Override
    public void onComplete() {
        logger.info("Transaction Processed");
    }
}

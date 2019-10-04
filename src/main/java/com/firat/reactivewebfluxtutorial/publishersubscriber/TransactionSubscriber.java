package com.firat.reactivewebfluxtutorial.publishersubscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionSubscriber implements Subscriber<Transaction> {
    Logger logger = LoggerFactory.getLogger(TransactionSubscriber.class);

    private Transaction transaction;
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
//        this.subscription.request(1);
    }

    @Override
    public void onNext(Transaction transaction) {
        this.transaction = transaction;
        // In the Mono object we use it within doOnNext() method. For example;
        // Mono.just(transaction)
        // .doOnNext(transaction->transaction.setStatus("IN PROGRESS")
        // .doOnNext(transaction->logger.info("onNext() the item: {}, {}",transaction.toString(),Thread.currentThread().getName()))
        transaction.setStatus("IN PROGRESS");
        logger.info("onNext() the item: {}, {}",transaction.toString(),Thread.currentThread().getName());
//        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        logger.error("",t);
    }

    @Override
    public void onComplete() {
        // In the Mono object we use it within doOnSuccess() method. For example;
        // Mono.just(transaction)
        // .doOnSuccess(transaction->transaction.setStatus("FINISHED")
        // .doOnSuccess(transaction->logger.info("onNext() the item: {}, {}",transaction.toString(),Thread.currentThread().getName()))

        this.transaction.setStatus("FINISHED");
        logger.info("onComplete() the item: {}, {}",transaction.toString(),Thread.currentThread().getName());
        logger.info("Transaction Processed");
    }
}

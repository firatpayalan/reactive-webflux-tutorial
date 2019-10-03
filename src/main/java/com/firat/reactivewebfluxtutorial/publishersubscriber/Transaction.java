package com.firat.reactivewebfluxtutorial.publishersubscriber;

public class Transaction {
    private int id;
    private double amount;
    private String label;
    private String status = "CREATED";

    public Transaction(int id, double amount, String label) {
        this.id = id;
        this.amount = amount;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", label='" + label + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

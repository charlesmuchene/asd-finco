package edu.miu.asd.finco.domain;

import java.time.LocalDate;

public abstract class IAccount {
    private String productNumber;
    private LocalDate openDate;
    private ICustomer customer;
    private double balance;
    private Card card;

    public abstract void executeEntry(IEntry entry);
    public abstract double getBalance();
    public abstract void notifyCustomer();
    public void setCard(Card card) {
        this.card = card;
    }
}

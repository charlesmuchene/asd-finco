package edu.miu.asd.finco.framework.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements IAccount {
    private String accountNumber;
    private LocalDate openDate;
    private double interestRate;

    private ICustomer customer;
    private double balance;
    private Card card;

    private List<IEntry> entries = new ArrayList<>();

    public Account(String accountNumber, LocalDate openDate, double interestRate,
                   ICustomer customer, double balance, Card card) {
        this.accountNumber = accountNumber;
        this.openDate = openDate;
        this.interestRate = interestRate;
        this.customer = customer;
        this.balance = balance;
        this.card = card;
    }

    public Account(double interestRate) {
        this.interestRate = interestRate;
    }

    public abstract void addInterest();

    @Override
    public void setCard(Card card) {
        this.card = card;
    }


    public void addEntry(IEntry entry) {
        entries.add(entry);
    }

    @Override
    public String toString() {
        return "Account{" +
                "productNumber='" + this.accountNumber + '\'' +
                ", openDate='" + this.openDate + '\'' +
                ", interestRate='" + this.interestRate + '\'' +
                ", balance='" + this.balance + '\'' +
//                ", card=" + this.card +
                '}';
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}

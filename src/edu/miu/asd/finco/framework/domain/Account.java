package edu.miu.asd.finco.framework.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Account implements IAccount {
    private String accountNumber;
    private LocalDate openDate;
    protected double interestRate;

    private ICustomer customer;
    protected double balance;
    private Card card;

    private List<ITransaction> transactions = new ArrayList<>();

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

    public void addInterest() {
        this.balance = this.balance + this.balance * this.interestRate;
    }

    @Override
    public void setCard(Card card) {
        this.card = card;
    }

    public void addTransaction(ITransaction transaction) {
        transactions.add(transaction);
    }

    public Iterator<ITransaction> getTransactions() {
        return transactions.iterator();
    }

    @Override
    public String toString() {
        return "Account{" +
                "productNumber='" + this.accountNumber + '\'' +
                ", openDate='" + this.openDate + '\'' +
                ", interestRate='" + this.interestRate + '\'' +
                ", balance='" + this.balance + '\'' +
                '}';
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public ICustomer getCustomer() {
        return customer;
    }

    @Override
    public void executeTransaction(ITransaction transaction) {
        if (transaction instanceof Withdraw) balance -= transaction.getAmount();
        else balance += transaction.getAmount();
    }
}

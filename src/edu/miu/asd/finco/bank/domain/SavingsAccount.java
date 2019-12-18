package edu.miu.asd.finco.bank.domain;

import edu.miu.asd.finco.framework.domain.Account;
import edu.miu.asd.finco.framework.domain.Card;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.domain.ITransaction;

import java.time.LocalDate;

public class SavingsAccount extends Account {

    public SavingsAccount(String productNumber, LocalDate openDate, double interestRate,
                          ICustomer customer, double balance, Card card) {
        super(productNumber, openDate, interestRate, customer, balance, card);
    }

    @Override
    public void addInterest() {

    }

    @Override
    public void executeTransaction(ITransaction transaction) {

    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void notifyCustomer() {
        System.out.println("Emailing customer on transaction");
    }

    @Override
    public String toString() {
        return "Savings Account";
    }
}

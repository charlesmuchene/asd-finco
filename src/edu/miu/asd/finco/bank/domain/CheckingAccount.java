package edu.miu.asd.finco.bank.domain;

import edu.miu.asd.finco.framework.domain.Account;
import edu.miu.asd.finco.framework.domain.Card;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.domain.ITransaction;

import java.time.LocalDate;

public class CheckingAccount extends Account {
    public CheckingAccount(String productNumber, LocalDate openDate, double interestRate,
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

    }

    @Override
    public String toString() {
        return "Checking Account";
    }
}

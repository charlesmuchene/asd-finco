package edu.miu.asd.finco.bank.domain;

import edu.miu.asd.finco.framework.domain.Account;
import edu.miu.asd.finco.framework.domain.Card;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.domain.IEntry;

import java.time.LocalDate;
import java.util.List;

public class SavingsAccount extends Account {

    public SavingsAccount(String productNumber, LocalDate openDate, double interestRate,
                          ICustomer customer, double balance, Card card) {
        super(productNumber, openDate, interestRate, customer, balance, card);
    }

    @Override
    public void addInterest() {

    }

    @Override
    public void executeEntry(IEntry entry) {

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
        return "Savings Account";
    }
}

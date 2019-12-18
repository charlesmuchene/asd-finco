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
    public double getBalance() {
        return balance;
    }

    @Override
    public void notifyCustomer() {
        System.out.println("Emailing Savings Account Customer on transaction");
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "interestRate=" + interestRate +
                ", balance=" + balance +
                '}';
    }
}

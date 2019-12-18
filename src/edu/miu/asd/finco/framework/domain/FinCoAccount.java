package edu.miu.asd.finco.framework.domain;

import java.time.LocalDate;

public class FinCoAccount extends Account {

    public FinCoAccount(String productNumber, LocalDate openDate, double interestRate,
                        ICustomer customer, double balance, Card card) {
        super(productNumber, openDate, interestRate, customer, balance, card);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void notifyCustomer() {
        System.out.println("Emailing Finco account");
    }

}

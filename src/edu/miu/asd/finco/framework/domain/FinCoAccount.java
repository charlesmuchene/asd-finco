package edu.miu.asd.finco.framework.domain;

import java.time.LocalDate;

public class FinCoAccount extends Account {

    public FinCoAccount(String productNumber, LocalDate openDate, double interestRate,
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
        System.out.println("Emailing Finco account");
    }

}

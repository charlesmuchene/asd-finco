package edu.miu.asd.finco.framework.domain;

import java.time.LocalDate;
import java.util.List;

public class FinCoAccount extends Account {

    public FinCoAccount(String productNumber, LocalDate openDate, double interestRate,
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

//    @Override
//    public String toString() {
////        String cardDetails;
//        return "Default: FinCoAccount";
////        return super.toString();
//    }
}

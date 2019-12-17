package edu.miu.asd.finco.framework.domain;

import java.time.LocalDate;

public interface IAccount {
    void executeEntry(IEntry entry);
    double getBalance();
    void notifyCustomer();
    void setCard(Card card);
    String getAccountNumber();
}

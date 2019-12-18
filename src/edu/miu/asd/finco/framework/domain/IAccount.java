package edu.miu.asd.finco.framework.domain;

public interface IAccount {
    void executeTransaction(ITransaction transaction);

    double getBalance();

    void notifyCustomer();

    void setCard(Card card);

    String getAccountNumber();

    ICustomer getCustomer();
}

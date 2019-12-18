package edu.miu.asd.finco.framework.domain;

public interface ITransaction {

    enum Type {DEPOSIT, WITHDRAW}

    /**
     * Execute this transaction
     */
    void execute();

    double getAmount();

}

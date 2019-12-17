package edu.miu.asd.finco.framework.domain;

public abstract class Account extends IAccount {
    private double interestRate;

    public abstract void addInterest();
}

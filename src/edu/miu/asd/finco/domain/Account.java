package edu.miu.asd.finco.domain;

public abstract class Account extends IAccount {
    private double interestRate;

    public abstract void addInterest();
}

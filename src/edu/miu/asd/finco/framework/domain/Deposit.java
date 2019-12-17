package edu.miu.asd.finco.framework.domain;

public class Deposit extends Entry {

    public Deposit(double amount, String description) {
        super(amount, description);
    }

    @Override
    public void execute() {

    }
}

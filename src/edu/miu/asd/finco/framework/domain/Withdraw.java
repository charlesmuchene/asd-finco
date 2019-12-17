package edu.miu.asd.finco.framework.domain;

public class Withdraw extends Entry {

    public Withdraw(double amount, String description) {
        super(amount, description);
    }

    @Override
    public void execute() {

    }
}

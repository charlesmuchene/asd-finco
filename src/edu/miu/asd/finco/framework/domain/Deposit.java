package edu.miu.asd.finco.framework.domain;

public class Deposit extends Transaction {

    public Deposit(double amount, String description) {
        super(amount, description, Type.DEPOSIT);
    }

    @Override
    public void execute() {
        System.out.println("Executing deposit");
    }
}

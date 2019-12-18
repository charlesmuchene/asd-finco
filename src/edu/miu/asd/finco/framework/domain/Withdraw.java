package edu.miu.asd.finco.framework.domain;

public class Withdraw extends Transaction {

    public Withdraw(double amount, String description) {
        super(amount, description, Type.WITHDRAW);
    }

    @Override
    public void execute() {
        System.out.println("Executing Withdraw");
    }
}

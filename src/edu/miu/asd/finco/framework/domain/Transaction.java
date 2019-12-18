package edu.miu.asd.finco.framework.domain;

import java.time.LocalDate;

public abstract class Transaction implements ITransaction {

    private final String description;
    private final double amount;
    private final LocalDate date;
    private Type type;

    public Transaction(double amount, String description, Type type) {
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.date = LocalDate.now();
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", type=" + type +
                '}';
    }
}

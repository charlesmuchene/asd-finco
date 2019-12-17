package edu.miu.asd.finco.framework.domain;

import java.time.LocalDate;

public abstract class Entry implements IEntry {

    private final String description;
    private final double amount;
    private final LocalDate date;

    public Entry(double amount, String description) {
        this.description = description;
        this.amount = amount;
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
}

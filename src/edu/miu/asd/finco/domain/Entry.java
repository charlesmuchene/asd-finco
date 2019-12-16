package edu.miu.asd.finco.domain;

import java.time.LocalDate;

public abstract class Entry implements IEntry {
    private String description;
    private double amount;
    private LocalDate date;
}

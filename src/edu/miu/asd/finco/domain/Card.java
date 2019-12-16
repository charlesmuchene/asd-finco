package edu.miu.asd.finco.domain;

import java.time.LocalDate;

public abstract class Card {
    private String cardNumber;
    private LocalDate expirationDate;
    private Account account;

    public abstract void execute(IEntry entry);
}

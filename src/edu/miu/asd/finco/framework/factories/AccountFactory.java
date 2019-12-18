package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.*;

import java.time.LocalDate;

public class AccountFactory implements AbstractAccountFactory {
    @Override
    public IAccount createAccount(String productNumber, LocalDate openDate,
                                  double interestRate, ICustomer customer, double balance, Card card) {
        return new FinCoAccount(productNumber, openDate, interestRate, customer, balance, card);
    }

    @Override
    public Card createCard() {
        return new FinCoCard();
    }
}

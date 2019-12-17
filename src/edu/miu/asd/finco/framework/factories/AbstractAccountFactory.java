package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.Card;
import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;

import java.time.LocalDate;

public interface AbstractAccountFactory {
    enum AccountType {CHECKING, SAVINGS}

    IAccount createAccount(AccountType type, String productNumber, LocalDate openDate,
                           double interestRate, ICustomer customer, double balance, Card card);
    Card createCard();
}

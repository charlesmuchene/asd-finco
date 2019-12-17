package edu.miu.asd.finco.bank;

import edu.miu.asd.finco.framework.domain.*;
import edu.miu.asd.finco.framework.factories.AbstractAccountFactory;

import java.time.LocalDate;

public class BankAccountFactory implements AbstractAccountFactory {

    @Override
    public IAccount createAccount(AccountType type, String productNumber, LocalDate openDate,
                                  double interestRate, ICustomer customer, double balance, Card card) {
        if (type.equals("CHECKING")) {
            return new CheckingAccount(productNumber, openDate, interestRate, customer, balance, card);
        } else {
        return new SavingsAccount(productNumber, openDate,interestRate, customer,  balance,  card);}
    }

    @Override
    public Card createCard() {
        return new FinCoCard();
    }


}

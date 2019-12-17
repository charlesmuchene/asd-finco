package edu.miu.asd.finco.bank.factories;

import edu.miu.asd.finco.bank.domain.CheckingAccount;
import edu.miu.asd.finco.bank.domain.SavingsAccount;
import edu.miu.asd.finco.framework.domain.*;
import edu.miu.asd.finco.framework.factories.AbstractAccountFactory;

import java.time.LocalDate;

public class BankAccountFactory implements AbstractAccountFactory {

    @Override
    public IAccount createAccount(AccountType type, String productNumber, LocalDate openDate,
                                  double interestRate, ICustomer customer, double balance, Card card) {
        if (type == AccountType.CHECKING) {
            return new CheckingAccount(productNumber, openDate, interestRate, customer, balance, null);
        } else {
        return new SavingsAccount(productNumber, openDate,interestRate, customer,  balance,  null);}
    }

    @Override
    public Card createCard() {
        return null;
    }


}

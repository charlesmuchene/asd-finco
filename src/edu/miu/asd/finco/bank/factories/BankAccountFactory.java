package edu.miu.asd.finco.bank.factories;

import edu.miu.asd.finco.bank.domain.AccountType;
import edu.miu.asd.finco.bank.domain.CheckingAccount;
import edu.miu.asd.finco.bank.domain.SavingsAccount;
import edu.miu.asd.finco.framework.domain.*;
import edu.miu.asd.finco.framework.factories.AbstractAccountFactory;

import java.time.LocalDate;

public class BankAccountFactory implements AbstractAccountFactory {
    private AccountType accountType;

    @Override
    public IAccount createAccount(String productNumber, LocalDate openDate,
                                  double interestRate, ICustomer customer, double balance, Card card) {
        if (this.accountType == AccountType.CHECKING) {
            return new CheckingAccount(productNumber, openDate, interestRate, customer, balance, null);
        } else {
            return new SavingsAccount(productNumber, openDate, interestRate, customer, balance, null);
        }
    }

    @Override
    public Card createCard() {
        return null;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }


}

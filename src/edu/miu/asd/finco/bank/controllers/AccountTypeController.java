package edu.miu.asd.finco.bank.controllers;

import edu.miu.asd.finco.bank.domain.AccountType;
import edu.miu.asd.finco.bank.factories.BankAccountFactory;

public class AccountTypeController {
    private BankAccountFactory bankAccountFactory;

    public AccountTypeController(BankAccountFactory bankAccountFactory) {
        this.bankAccountFactory = bankAccountFactory;
    }

    public void setAccountType(AccountType type) {
        this.bankAccountFactory.setAccountType(type);
    }
}

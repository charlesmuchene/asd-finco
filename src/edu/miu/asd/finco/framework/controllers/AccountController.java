package edu.miu.asd.finco.framework.controllers;

import edu.miu.asd.finco.framework.dao.FincoDao;
import edu.miu.asd.finco.framework.domain.Card;
import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.factories.AbstractAccountFactory;

import java.time.LocalDate;

public class AccountController {
    private FincoDao fincoDao;
    private AbstractAccountFactory accountFactory;

    public AccountController(FincoDao fincoDao, AbstractAccountFactory accountFactory) {
        this.fincoDao = fincoDao;
        this.accountFactory = accountFactory;
    }

    /**
     * Create account
     *
     * @param accountNumber Account number
     * @param openDate      Account open date
     * @param interestRate  Interest rate
     * @param customer      Account owner
     * @param balance       Account balance
     * @param card          Card linked to the account
     */

    public void addAccount(String accountNumber, LocalDate openDate, double interestRate,
                           ICustomer customer, double balance, Card card) {
        IAccount account = accountFactory.createAccount(
                accountNumber, openDate, interestRate, customer, balance, null);
        fincoDao.saveAccount(account);
        customer.addAccount(account);
    }
}

package edu.miu.asd.finco.framework.controllers;

import edu.miu.asd.finco.framework.dao.FincoDao;
import edu.miu.asd.finco.framework.domain.Card;
import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.factories.AbstractAccountFactory;
import edu.miu.asd.finco.framework.factories.AbstractCustomerFactory;

import java.time.LocalDate;
import java.util.OptionalDouble;

public class CustomerController {
    private FincoDao fincoDao;
    private AbstractCustomerFactory customerFactory;

    public CustomerController(FincoDao fincoDao, AbstractCustomerFactory customerFactory) {
        this.fincoDao = fincoDao;
        this.customerFactory = customerFactory;
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

    public void CreateCustomer(String accountNumber, LocalDate openDate, double interestRate,
                               ICustomer customer, double balance, Card card) {
//        IAccount account = customerFactory.createCustomer(accountNumber, openDate, interestRate, customer, balance,null);
//        fincoDao.saveAccount(account);
    }
}

package edu.miu.asd.finco.framework.controllers;

import edu.miu.asd.finco.framework.dao.FincoDao;
import edu.miu.asd.finco.framework.domain.Card;
import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.factories.AbstractAccountFactory;
import edu.miu.asd.finco.framework.factories.AbstractCustomerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;

public class CustomerController {
    private FincoDao fincoDao;
    private AbstractCustomerFactory customerFactory;

    public CustomerController(FincoDao fincoDao, AbstractCustomerFactory customerFactory) {
        this.fincoDao = fincoDao;
        this.customerFactory = customerFactory;
    }

    /**
     * Create customer
     *
     * @param opt           Customer type: Organization, Person
     * @param name          Customer name
     * @param street        Customer address: street
     * @param city          Customer address: city
     * @param zip           Customer address: zip code
     * @param state         Customer address: state
     * @param email         Customer email
     * @param accounts      Accounts owned by customerr
     * @param nOfEmployees  Company: number of employees
     * @param birthDate     Person: date of birth
     * @return {ICustomer} customer
     */

    public ICustomer CreateCustomer(ICustomer.Type opt, String name, String street, String city, String zip,
                                    String state, String email, List<IAccount> accounts, int nOfEmployees,
                                    LocalDate birthDate) {

                ICustomer customer = customerFactory.createCustomer(opt, name, street, city, zip, state, email,
                        null, nOfEmployees, birthDate);
                fincoDao.saveCustomer(customer);
                return customer;

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

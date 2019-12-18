package edu.miu.asd.finco.framework.controllers;

import edu.miu.asd.finco.framework.dao.FincoDao;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.factories.AbstractCustomerFactory;

import java.time.LocalDate;

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
     * @param opt          Customer type: Organization, Person
     * @param name         Customer name
     * @param street       Customer address: street
     * @param city         Customer address: city
     * @param zip          Customer address: zip code
     * @param state        Customer address: state
     * @param email        Customer email
     * @param nOfEmployees Company: number of employees
     * @param birthDate    Person: date of birth
     * @return {@link ICustomer} customer
     */
    public ICustomer createCustomer(ICustomer.Type opt, String name, String street, String city, String zip,
                                    String state, String email, int nOfEmployees,
                                    LocalDate birthDate) {

        ICustomer customer = customerFactory.createCustomer(opt, name, street, city, zip, state, email, nOfEmployees, birthDate);
        fincoDao.saveCustomer(customer);
        return customer;

    }
}

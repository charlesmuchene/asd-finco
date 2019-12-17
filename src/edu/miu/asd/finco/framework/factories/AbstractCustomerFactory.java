package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;

import java.time.LocalDate;
import java.util.List;



public interface AbstractCustomerFactory {
    ICustomer createCustomer(ICustomer.Type opt, String name, String street, String city, String zip,String state,String email, List<IAccount> accounts, int nOfEmployees, LocalDate birthDate);
}

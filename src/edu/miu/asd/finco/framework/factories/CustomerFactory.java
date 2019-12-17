package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.domain.Organization;
import edu.miu.asd.finco.framework.domain.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerFactory implements AbstractCustomerFactory {
    @Override
//    public ICustomer createCustomer() {
//        return new Organization();
//    }birthDate

    public ICustomer createCustomer(String name, String street, String city, String zip,String state,String email, List<IAccount> accounts, int nOfEmployees) {

        return new Organization(name, street, city, zip, state, email, accounts, nOfEmployees);
    }
    public ICustomer createCustomer(ICustomer.Type opt, String name, String street, String city, String zip,String state,String email, List<IAccount> accounts, int nOfEmployees, LocalDate birthDate) {

        if (opt == ICustomer.Type.ORGANIZATION)
        {
            return new Organization(name, street, city, zip, state, email, accounts, nOfEmployees);
        }
        else
        {
            return new Person(name, street, city, zip, state, email, accounts, birthDate);
        }


    }


}

package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.domain.Organization;
import edu.miu.asd.finco.framework.domain.Person;

import java.time.LocalDate;
import java.util.List;

public class CustomerFactory implements AbstractCustomerFactory {

    @Override
    public ICustomer createCustomer(ICustomer.Type type, String name, String street, String city, String zip, String state, String email, List<IAccount> accounts, int nOfEmployees, LocalDate birthDate) {

        switch (type) {
            case ORGANIZATION:
                return new Organization(name, street, city, zip, state, email, accounts, nOfEmployees);
            case PERSON:
                return new Person(name, street, city, zip, state, email, accounts, birthDate);
        }

        throw new IllegalArgumentException("Unknown type " + type);

    }


}

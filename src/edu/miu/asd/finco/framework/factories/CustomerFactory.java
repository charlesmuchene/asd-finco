package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.domain.Organization;

import java.util.ArrayList;
import java.util.List;

public class CustomerFactory implements AbstractCustomerFactory {
    @Override
//    public ICustomer createCustomer() {
//        return new Organization();
//    }
    public ICustomer createCustomer() {
        String name = "Financial Company";
        String street = "1000 N 4th St";
        String city = "Fairfield";
        String zip = "52557";
        String state = "IA";
        String email = "finco@miu.edu";
        List<IAccount> accounts = new ArrayList<>();
        int nOfEmployees = 200;

        return new Organization(name, street, city, zip,
                state, email, accounts,nOfEmployees);
    }
}

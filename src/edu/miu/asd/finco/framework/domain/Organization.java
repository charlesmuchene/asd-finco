package edu.miu.asd.finco.framework.domain;

import java.util.ArrayList;
import java.util.List;

public class Organization extends Customer implements IOrganization {
    private int nOfEmployees;
    private List<IPerson> employees = new ArrayList<>();

    public Organization(String name, String street, String city, String zip,
                        String state, String email, List<IAccount> accounts,
                        int nOfEmployees) {
        super(name, street, city, zip, state, email, accounts);
        this.nOfEmployees = nOfEmployees;
    }
}

package edu.miu.asd.finco.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer implements ICustomer{
    private String name;
    private String street;
    private String city;
    private String zip;
    private String state;
    private String email;

    private List<IAccount> accounts = new ArrayList<>();

    public void addAccount(IAccount account) {
        accounts.add(account);
    }
}

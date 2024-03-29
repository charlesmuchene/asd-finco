package edu.miu.asd.finco.framework.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Customer implements ICustomer {
    private String name;
    private String street;
    private String city;
    private String zip;
    private String state;
    private String email;

    private List<IAccount> accounts = new ArrayList<>();

    public Customer(String name, String street, String city, String zip,
                    String state, String email) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.email = email;
    }

    @Override
    public void addAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void removeAccount(IAccount account) {
        accounts.remove(account);
    }

    public Iterator<IAccount> getAllAccounts() {
        return accounts.iterator();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}

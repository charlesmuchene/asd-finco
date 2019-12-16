package edu.miu.asd.finco.dao;

import edu.miu.asd.finco.domain.IAccount;
import edu.miu.asd.finco.domain.ICustomer;

import java.util.ArrayList;
import java.util.List;

public class InMemoryFinCoDao implements FinCoDao {
    private List<ICustomer> customers = new ArrayList<>();
    private List<IAccount> accounts = new ArrayList<>();

    @Override
    public void saveCustomer(ICustomer customer) {
        customers.add(customer);
    }

    @Override
    public void saveAccount(IAccount account) {
        accounts.add(account);
    }
}

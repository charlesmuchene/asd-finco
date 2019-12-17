package edu.miu.asd.finco.framework.dao;

import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public Iterator<ICustomer> getAllCustomers() {
        return customers.iterator();
    }

    @Override
    public Iterator<IAccount> getAllAccounts() {
        return accounts.iterator();
    }
}

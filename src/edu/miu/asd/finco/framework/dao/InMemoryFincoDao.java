package edu.miu.asd.finco.framework.dao;

import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.domain.ITransaction;

import java.util.*;

public class InMemoryFincoDao implements FincoDao {

    private List<ICustomer> customers = new ArrayList<>();
    private Map<String, IAccount> accounts = new HashMap<>();
    private List<ITransaction> transactions = new ArrayList<>();

    @Override
    public void saveCustomer(ICustomer customer) {
        customers.add(customer);
    }

    @Override
    public void saveAccount(IAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    @Override
    public void saveTransaction(ITransaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public Iterator<ICustomer> getAllCustomers() {
        return customers.iterator();
    }

    @Override
    public Iterator<IAccount> getAllAccounts() {
        return accounts.values().iterator();
    }

    @Override
    public Iterator<ITransaction> getAllTransactions() {
        return transactions.iterator();
    }

    @Override
    public Optional<IAccount> findAccount(String accountNumber) {
        return accounts.containsKey(accountNumber) ? Optional.of(accounts.get(accountNumber)) : Optional.empty();
    }

    @Override
    public void updateAccount(IAccount account) {
        accounts.computeIfPresent(account.getAccountNumber(), (s, account1) -> account);
    }
}

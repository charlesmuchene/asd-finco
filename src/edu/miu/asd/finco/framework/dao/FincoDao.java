package edu.miu.asd.finco.framework.dao;

import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;

import java.util.Iterator;
import java.util.Optional;

public interface FincoDao {

    void saveCustomer(ICustomer customer);

    void saveAccount(IAccount account);

    Iterator<ICustomer> getAllCustomers();

    Iterator<IAccount> getAllAccounts();

    Optional<IAccount> findAccount(String accountNumber);

    void updateAccount(IAccount account);

}

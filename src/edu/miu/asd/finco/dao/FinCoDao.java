package edu.miu.asd.finco.dao;

import edu.miu.asd.finco.domain.IAccount;
import edu.miu.asd.finco.domain.ICustomer;

import java.util.Iterator;

public interface FinCoDao {
    void saveCustomer(ICustomer customer);
    void saveAccount(IAccount account);

//    Iterator<ICustomer>
}

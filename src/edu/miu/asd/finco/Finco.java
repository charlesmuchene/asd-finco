package edu.miu.asd.finco;

import edu.miu.asd.finco.dao.FinCoDao;
import edu.miu.asd.finco.dao.InMemoryFinCoDao;
import edu.miu.asd.finco.domain.Card;
import edu.miu.asd.finco.domain.IAccount;
import edu.miu.asd.finco.domain.ICustomer;
import edu.miu.asd.finco.domain.IEntry;
import edu.miu.asd.finco.factories.*;

public class Finco {

    public static void main(String[] args) {
        System.out.println("Financial Company");
        System.out.println("-----------------------------");

//        Instantiate default functionality
        AbstractCustomerFactory customerFactory = new CustomerFactory();
        AbstractAccountFactory accountFactory = new AccountFactory();
        AbstractEntryFactory entryFactory = new EntryFactory();

        ICustomer customer = customerFactory.createCustomer();
        IAccount account = accountFactory.createAccount();
        Card card = accountFactory.createCard();
        IEntry entry = entryFactory.createEntry();

        account.setCard(card);

        card.execute(entry);

        customer.addAccount(account);

        FinCoDao finCoDao = new InMemoryFinCoDao();
        finCoDao.saveAccount(account);
        finCoDao.saveCustomer(customer);

        // Use
        finCoDao.getAllAccounts().forEachRemaining(System.out::println);
        finCoDao.getAllCustomers().forEachRemaining(System.out::println);

    }
}

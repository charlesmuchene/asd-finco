package edu.miu.asd.finco;

import edu.miu.asd.finco.framework.dao.FinCoDao;
import edu.miu.asd.finco.framework.dao.InMemoryFinCoDao;
import edu.miu.asd.finco.framework.domain.Card;
import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.domain.IEntry;
import edu.miu.asd.finco.framework.factories.*;
import edu.miu.asd.finco.ui.bank.BankFrm;

import java.time.LocalDate;

public class Finco {

    private AbstractCustomerFactory customerFactory;
    private AbstractAccountFactory accountFactory;
    private AbstractEntryFactory entryFactory;

    public Finco() {
        this.customerFactory = new CustomerFactory();
        this.accountFactory = new AccountFactory();
        this.entryFactory = new EntryFactory();
    }

    public void setAccountFactory(AbstractAccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    public void setCustomerFactory(AbstractCustomerFactory customerFactory) {
        this.customerFactory = customerFactory;
    }

    public void setEntryFactory(AbstractEntryFactory entryFactory) {
        this.entryFactory = entryFactory;
    }

    public AbstractCustomerFactory getCustomerFactory() {
        return customerFactory;
    }

    public AbstractAccountFactory getAccountFactory() {
        return accountFactory;
    }

    public AbstractEntryFactory getEntryFactory() {
        return entryFactory;
    }

    public static void main(String[] args) {
        System.out.println("Financial Company");
        System.out.println("-----------------------------");

        Finco finco = new Finco();

        String productNumber = "0000001";
        LocalDate openDate = LocalDate.now();
        double interestRate = 0;
        double balance = 0;

        ICustomer customer = finco.getCustomerFactory().createCustomer();
        IAccount account = finco.getAccountFactory().createAccount(null, productNumber, openDate, interestRate, customer, balance, null);
        IEntry entry = finco.getEntryFactory().createEntry();
        Card card = finco.getAccountFactory().createCard();

        card.execute(entry);
        account.setCard(card);
        customer.addAccount(account);

        // Persistence
        FinCoDao finCoDao = new InMemoryFinCoDao();
        finCoDao.saveAccount(account);
        finCoDao.saveCustomer(customer);

        // Use
        finCoDao.getAllAccounts().forEachRemaining(System.out::println);
        finCoDao.getAllCustomers().forEachRemaining(System.out::println);

        BankFrm bankFrm = new BankFrm();
        bankFrm.setVisible(true);

    }
}

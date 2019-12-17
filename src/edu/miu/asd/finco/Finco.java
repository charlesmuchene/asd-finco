package edu.miu.asd.finco;

import edu.miu.asd.finco.framework.dao.FinCoDao;
import edu.miu.asd.finco.framework.dao.InMemoryFinCoDao;
import edu.miu.asd.finco.framework.domain.Card;
import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.domain.IEntry;
import edu.miu.asd.finco.framework.factories.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        String name = "Financial Company";
        String street = "1000 N 4th St";
        String city = "Fairfield";
        String zip = "52557";
        String state = "IA";
        String email = "finco@miu.edu";
        List<IAccount> accounts = new ArrayList<>();
        int nOfEmployees = 200;
        String opt = "O";
        LocalDate birthDate = null;
        // Default Customer (Organization)
        ICustomer customer = finco.getCustomerFactory().createCustomer(name, street, city, zip, state,  email, accounts, nOfEmployees);

        // If opt = "O": Organization, opt == "P" : Person
        ICustomer customer2 = finco.getCustomerFactory().createCustomer(opt, name, street, city, zip, state,  email, accounts, nOfEmployees, birthDate);

        IAccount account = finco.getAccountFactory().createAccount();
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

    }
}

package edu.miu.asd.finco.framework;

import edu.miu.asd.finco.framework.dao.FinCoDao;
import edu.miu.asd.finco.framework.dao.InMemoryFinCoDao;
import edu.miu.asd.finco.framework.domain.Card;
import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.domain.IEntry;
import edu.miu.asd.finco.framework.factories.*;
import java.time.LocalDate;
import edu.miu.asd.finco.framework.ui.ApplicationForm;

import javax.swing.*;

public class FincoApplication {

    private AbstractCustomerFactory customerFactory;
    private AbstractAccountFactory accountFactory;
    private AbstractEntryFactory entryFactory;
    private FinCoDao dao = new InMemoryFinCoDao();
    private ApplicationForm applicationForm = new ApplicationForm();

    public FincoApplication() {
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

    public void setApplicationForm(ApplicationForm applicationForm) {
        this.applicationForm = applicationForm;
    }

    public void setDao(FinCoDao finCoDao) {
        this.dao = finCoDao;
    }

    public void launch() {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            applicationForm.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Financial Company");
        System.out.println("-----------------------------");

        FincoApplication fincoApplication = new FincoApplication();
        fincoApplication.launch();

        String productNumber = "0000001";
        LocalDate openDate = LocalDate.now();
        double interestRate = 0;
        double balance = 0;

        ICustomer customer = fincoApplication.getCustomerFactory().createCustomer();
        IAccount account = fincoApplication.getAccountFactory().createAccount(null, productNumber, openDate, interestRate, customer, balance, null);
        IEntry entry = fincoApplication.getEntryFactory().createEntry();
        Card card = fincoApplication.getAccountFactory().createCard();
    }
}

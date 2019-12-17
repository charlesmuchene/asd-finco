package edu.miu.asd.finco.framework;

import edu.miu.asd.finco.framework.controllers.TransactionController;
import edu.miu.asd.finco.framework.dao.FincoDao;
import edu.miu.asd.finco.framework.dao.InMemoryFincoDao;
import edu.miu.asd.finco.framework.factories.*;
import edu.miu.asd.finco.framework.ui.ApplicationForm;

import javax.swing.*;

public class FincoApplication {

    private AbstractCustomerFactory customerFactory;
    private AbstractAccountFactory accountFactory;
    private AbstractEntryFactory entryFactory;
    private FincoDao dao = new InMemoryFincoDao();
    private ApplicationForm applicationForm;
    private TransactionController transactionController;

    public FincoApplication() {
        this.customerFactory = new CustomerFactory();
        this.accountFactory = new AccountFactory();
        this.entryFactory = new EntryFactory();
        this.applicationForm = new ApplicationForm();
        this.transactionController = new TransactionController(dao, this.entryFactory);
        this.applicationForm.setTransactionController(this.transactionController);
    }

    public void setAccountFactory(AbstractAccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    public void setCustomerFactory(AbstractCustomerFactory customerFactory) {
        this.customerFactory = customerFactory;
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

    public void setDao(FincoDao finCoDao) {
        this.dao = finCoDao;
    }

    public TransactionController getTransactionController() {
        return transactionController;
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

    }
}

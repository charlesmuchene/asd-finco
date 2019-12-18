package edu.miu.asd.finco.framework.ui;

import edu.miu.asd.finco.framework.controllers.AccountController;
import edu.miu.asd.finco.framework.controllers.CustomerController;
import edu.miu.asd.finco.framework.controllers.TransactionController;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.ui.dialogs.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.OptionalDouble;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ApplicationForm extends JFrame {
    public String accountNumber;
    public String clientName;
    public String street;
    public String city;
    public String zip;
    public String state;
    public String accountType = "--";
    public String transactionAmount;
    public String email;
    public String noOfEmployees;
    public boolean isNewAccount;
    public String dateOfBirth;
    private DefaultTableModel model;
    private JTable table;
    private Object[] rowData;

    private JButton personalAccountButton = new JButton();
    private JButton companyAccountButton = new JButton();
    private JButton depositButton = new JButton();
    private JButton withdrawButton = new JButton();
    private JButton addInterestButton = new JButton();
    private JButton exitButton = new JButton();

    private TransactionController transactionController;
    private AccountController accountController;
    private CustomerController customerController;

    private AccountDialog.AccountTypeFunctor accountTypeFunctor = new AccountDialog.AccountTypeFunctor() {
    };
    private Consumer<Object> applicationExitFunctor = System.out::println;

    public ApplicationForm() {
        this("Finco Application", null);
    }

    public ApplicationForm(String title, BiConsumer<JPanel, Rectangle> customButtonFunctor) {

        setTitle(title);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(615, 350);
        setVisible(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, panel);
        panel.setBounds(0, 0, 615, 350);
        JScrollPane scrollPane = new JScrollPane();
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        rowData = new Object[8];
        isNewAccount = false;

        panel.add(scrollPane);
        scrollPane.setBounds(12, 92, 444, 160);
        scrollPane.getViewport().add(table);
        table.setBounds(0, 0, 420, 0);

        personalAccountButton.setText("Add personal account");
        panel.add(personalAccountButton);
        personalAccountButton.setBounds(24, 20, 192, 33);
        companyAccountButton.setText("Add company account");
        companyAccountButton.setActionCommand("jbutton");
        panel.add(companyAccountButton);
        companyAccountButton.setBounds(240, 20, 192, 33);
        depositButton.setText("Deposit");
        panel.add(depositButton);
        depositButton.setBounds(468, 104, 96, 33);
        withdrawButton.setText("Withdraw");
        panel.add(withdrawButton);

        if (customButtonFunctor != null) {
            Rectangle bounds = new Rectangle(448, 20, 106, 33);
            customButtonFunctor.accept(panel, bounds);
        }

        withdrawButton.setBounds(468, 164, 96, 33);
        exitButton.setText("Exit");
        panel.add(exitButton);
        exitButton.setBounds(468, 248, 96, 31);
        personalAccountButton.setActionCommand("jbutton");

        FincoWindowAdapter fincoWindowAdapter = new FincoWindowAdapter();
        this.addWindowListener(fincoWindowAdapter);
        FincoWindowActionListener fincoWindowActionListener = new FincoWindowActionListener();
        exitButton.addActionListener(fincoWindowActionListener);
        personalAccountButton.addActionListener(fincoWindowActionListener);
        companyAccountButton.addActionListener(fincoWindowActionListener);
        depositButton.addActionListener(fincoWindowActionListener);
        withdrawButton.addActionListener(fincoWindowActionListener);
        addInterestButton.addActionListener(fincoWindowActionListener);

    }

    private void exitApplication() {
        try {
            this.applicationExitFunctor.accept(new Object());
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class FincoWindowAdapter extends java.awt.event.WindowAdapter {
        public void windowClosing(WindowEvent event) {
            if (event.getSource() == ApplicationForm.this)
                windowClosingWithEvent(event);
        }
    }

    private void windowClosingWithEvent(WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class FincoWindowActionListener implements java.awt.event.ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object object = event.getSource();
            if (object == exitButton)
                exitButtonActionPerformed(event);
            else if (object == personalAccountButton)
                personalAccountButtonActionPerformed(event);
            else if (object == companyAccountButton)
                companyAccountButtonActionPerformed(event);
            else if (object == depositButton)
                depositButtonActionPerformed(event);
            else if (object == withdrawButton)
                withdrawButtonActionPerformed(event);
            else if (object == addInterestButton)
                addInterestButtonActionPerformed(event);

        }
    }

    private void exitButtonActionPerformed(ActionEvent event) {
        exitApplication();
    }

    private void personalAccountButtonActionPerformed(ActionEvent event) {
        AccountDialog dialog = new PersonalAccountDialog(ApplicationForm.this, accountTypeFunctor);
        showDialog(dialog, 450, 20, 320, 370);
        addAccount(ICustomer.Type.PERSON);
    }

    private void companyAccountButtonActionPerformed(ActionEvent event) {
        AccountDialog dialog = new CompanyAccountDialog(ApplicationForm.this, accountTypeFunctor);
        showDialog(dialog, 450, 20, 300, 330);
        addAccount(ICustomer.Type.ORGANIZATION);
    }

    /**
     * Add account
     *
     * @param type {@link ICustomer.Type} instance
     */
    private void addAccount(ICustomer.Type type) {

        int employees = -1;
        LocalDate date = LocalDate.MIN;
        ICustomer.Type opt = ICustomer.Type.ORGANIZATION;

        try {

            switch (type) {
                case ORGANIZATION:
                    employees = Integer.parseInt(noOfEmployees);
                    break;
                case PERSON:
                    date = LocalDate.now();//LocalDate.parse(dateOfBirth);
                    break;
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            e.printStackTrace();
            System.out.println("Error creating account");
            return;
        }

        ICustomer customer = customerController.createCustomer(type, clientName, street, city, zip, state, email, employees, date);

        accountController.addAccount(accountNumber, LocalDate.now(), 3.0, customer, 0, null);

        if (isNewAccount) {
            rowData[0] = accountNumber;
            rowData[1] = clientName;
            rowData[2] = city;
            rowData[3] = type.initials;
            rowData[4] = accountType;
            rowData[5] = "0";
            model.addRow(rowData);
            table.getSelectionModel().setAnchorSelectionIndex(-1);
            isNewAccount = false;
        }
    }

    private void showDialog(JDialog dialog, int x, int y, int width, int height) {
        dialog.setBounds(x, y, width, height);
        dialog.setVisible(true);
    }

    private void depositButtonActionPerformed(ActionEvent event) {

        // get selected name
        int selection = table.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accountNumber = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding deposit amount for the current mane
            TransactionDialog dialog = new DepositDialog(ApplicationForm.this, accountNumber);
            showDialog(dialog, 430, 15, 275, 140);

            if (transactionController != null) {
                OptionalDouble newAmount = transactionController.makeDeposit(transactionAmount, accountNumber, "");
                if (newAmount.isPresent())
                    model.setValueAt(String.valueOf(newAmount.getAsDouble()), selection, 5);
            }
        }

    }

    private void withdrawButtonActionPerformed(ActionEvent event) {

        // get selected name
        int selection = table.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accountNumber = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding withdraw amount for the current mane
            TransactionDialog dialog = new WithdrawDialog(ApplicationForm.this, accountNumber);
            showDialog(dialog, 430, 15, 275, 140);

            if (transactionController != null) {
                OptionalDouble newAmount = transactionController.makeWithdraw(transactionAmount, accountNumber, "");
                if (newAmount.isPresent()) {
                    model.setValueAt(String.valueOf(newAmount.getAsDouble()), selection, 5);
                    if (newAmount.getAsDouble() < 0) {
                        JOptionPane.showMessageDialog(withdrawButton, " Account " + accountNumber + " : balance is negative: $" + newAmount.getAsDouble() + " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }

    }

    private void addInterestButtonActionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(addInterestButton, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
    }

    public void setTransactionController(TransactionController transactionController) {
        this.transactionController = transactionController;
    }

    public void setAccountController(AccountController accountController) {
        this.accountController = accountController;
    }

    public void setCustomerController(CustomerController customerController) {
        this.customerController = customerController;
    }

    public void setAccountTypeFunctor(AccountDialog.AccountTypeFunctor accountTypeFunctor) {
        this.accountTypeFunctor = accountTypeFunctor;
    }

    public void setApplicationExitFunctor(Consumer<Object> applicationExitFunctor) {
        this.applicationExitFunctor = applicationExitFunctor;
    }
}

package edu.miu.asd.finco.framework.ui;

import edu.miu.asd.finco.framework.ui.dialogs.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class ApplicationForm extends JFrame {
    public String accountNumber;
    public String clientName;
    public String street;
    public String city;
    public String zip;
    public String state;
    public String accountType;
    public String amountDeposit;
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

    public ApplicationForm() {

        setTitle("Finco Application");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(575, 310);
        setVisible(false);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, panel);
        panel.setBounds(0, 0, 575, 310);
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
        addInterestButton.setBounds(448, 20, 106, 33);
        addInterestButton.setText("Add interest");
        panel.add(addInterestButton);
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

    public static void main(String[] args) {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Create a new instance of our application's frame, and make it visible.
            (new ApplicationForm()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    private void exitApplication() {
        try {
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
        System.exit(0);
    }

    private void personalAccountButtonActionPerformed(ActionEvent event) {
        AccountDialog dialog = new PersonalAccountDialog(ApplicationForm.this);
        showDialog(dialog, 450, 20, 300, 330);
        addAccount(AccountDialog.ACCOUNT_TYPE.PERSONAL);
    }

    private void companyAccountButtonActionPerformed(ActionEvent event) {
        AccountDialog dialog = new CompanyAccountDialog(ApplicationForm.this);
        showDialog(dialog, 450, 20, 300, 330);
        addAccount(AccountDialog.ACCOUNT_TYPE.COMPANY);
    }

    /**
     * Add account
     *
     * @param type {@link AccountDialog.ACCOUNT_TYPE} instance
     */
    private void addAccount(AccountDialog.ACCOUNT_TYPE type) {

        // TODO Use the custom field to create models

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

            // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String amount = (String) model.getValueAt(selection, 5);
            long currentAmount = Long.parseLong(amount);
            long newAmount = currentAmount + deposit;
            model.setValueAt(String.valueOf(newAmount), selection, 5);
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

            // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String amount = (String) model.getValueAt(selection, 5);
            long currentAmount = Long.parseLong(amount);
            long newAmount = currentAmount - deposit;
            model.setValueAt(String.valueOf(newAmount), selection, 5);
            if (newAmount < 0) {
                JOptionPane.showMessageDialog(withdrawButton, " Account " + accountNumber + " : balance is negative: $" + String.valueOf(newAmount) + " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    private void addInterestButtonActionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(addInterestButton, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
    }
}

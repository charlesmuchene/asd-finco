package edu.miu.asd.finco.framework.ui.dialogs;

import edu.miu.asd.finco.framework.ui.ApplicationForm;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public abstract class AccountDialog extends JDialog {

    private ApplicationForm applicationForm;

    private JButton okayButton = new JButton();
    private JButton cancelButton = new JButton();
    private JTextField zipTextField = new JTextField();
    private JTextField nameTextField = new JTextField();
    private JTextField stateTextField = new JTextField();
    private JTextField streetTextField = new JTextField();
    private JTextField contactTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JTextField customTextField = new JTextField();
    private JTextField accountNumberTextField = new JTextField();

    private AccountTypeFunctor accountTypeFunctor;

    public AccountDialog(ApplicationForm applicationForm, String customFieldTitle, AccountTypeFunctor accountTypeFunctor) {
        super(applicationForm);
        this.applicationForm = applicationForm;
        this.accountTypeFunctor = accountTypeFunctor;

        setTitle("Add Account");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(298, 339);
        setVisible(false);

        accountTypeFunctor.addUI(getContentPane());

        createLabel("Name", 96, 48);
        createLabel("Street", 120, 48);
        createLabel("City", 144, 48);
        createLabel("State", 168, 48);
        createLabel("Zip", 192, 48);
        createLabel(customFieldTitle, 216, 96);
        createLabel("Email", 240, 48);

        getContentPane().add(nameTextField);
        nameTextField.setBounds(120, 96, 156, 20);
        getContentPane().add(contactTextField);
        contactTextField.setBounds(120, 144, 156, 20);
        getContentPane().add(stateTextField);
        stateTextField.setBounds(120, 168, 156, 20);
        getContentPane().add(streetTextField);
        streetTextField.setBounds(120, 120, 156, 20);
        getContentPane().add(zipTextField);
        zipTextField.setBounds(120, 192, 156, 20);
        getContentPane().add(customTextField);
        customTextField.setBounds(120, 216, 156, 20);
        getContentPane().add(emailTextField);
        emailTextField.setBounds(120, 240, 156, 20);
        okayButton.setText("OK");
        okayButton.setActionCommand("OK");
        getContentPane().add(okayButton);
        okayButton.setBounds(48, 276, 84, 24);
        cancelButton.setText("Cancel");
        cancelButton.setActionCommand("Cancel");
        getContentPane().add(cancelButton);
        cancelButton.setBounds(156, 276, 84, 24);
        createLabel("Acc Nr", 72, 48);
        getContentPane().add(accountNumberTextField);
        accountNumberTextField.setBounds(120, 72, 156, 20);

        SymAction lSymAction = new SymAction();
        okayButton.addActionListener(lSymAction);
        cancelButton.addActionListener(lSymAction);

    }

    private void createLabel(String text, int y, int width) {
        JLabel label = new JLabel();
        label.setText(text);
        getContentPane().add(label);
        label.setForeground(Color.black);
        label.setBounds(12, y, width, 24);
    }

    private class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == okayButton)
                okayButtonActionPerformed(event);
            else if (object == cancelButton)
                cancelButtonActionPerformed(event);
        }
    }

    private void okayButtonActionPerformed(java.awt.event.ActionEvent event) {
        applicationForm.accountNumber = accountNumberTextField.getText();
        applicationForm.clientName = nameTextField.getText();
        applicationForm.street = streetTextField.getText();
        applicationForm.city = contactTextField.getText();
        applicationForm.zip = zipTextField.getText();
        applicationForm.email = emailTextField.getText();
        applicationForm.state = stateTextField.getText();
        applicationForm.accountType = accountTypeFunctor.getAccountType();
        applicationForm.isNewAccount = true;

        processCustomField(applicationForm, customTextField.getText());

        dispose();
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent event) {
        dispose();
    }

    /**
     * Process custom field
     *
     * @param applicationForm {@link ApplicationForm} instance
     * @param value           Value to use
     */
    protected abstract void processCustomField(ApplicationForm applicationForm, String value);

    /**
     * Account type
     */
    public enum ACCOUNT_TYPE {

        PERSONAL("P"), COMPANY("C");

        public String initials;

        ACCOUNT_TYPE(String initial) {
            this.initials = initial;
        }
    }

    /**
     * Account type functor
     */
    public interface AccountTypeFunctor {

        default void addUI(Container container) {
            // No op
        }

        default String getAccountType() {
            return "--";
        }

    }

}
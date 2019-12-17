package edu.miu.asd.finco.framework.ui.dialogs;

import edu.miu.asd.finco.framework.ui.ApplicationForm;

import javax.swing.*;
import java.awt.*;

public abstract class TransactionDialog extends JDialog {

    private ApplicationForm applicationForm;
    private JButton okayButton = new JButton();
    private JButton cancelButton = new JButton();
    private JTextField depositTextField = new JTextField();

    public TransactionDialog(ApplicationForm parent, String accountNumber) {
        super(parent);
        applicationForm = parent;
        setModal(true);
        setTitle(getDialogTitle());
        getContentPane().setLayout(null);
        setSize(268, 126);
        setVisible(false);
        JLabel JLabel1 = new JLabel();
        JLabel1.setText("Acc Nr");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(Color.black);
        JLabel1.setBounds(12, 12, 48, 24);
        JLabel JLabel2 = new JLabel();
        JLabel2.setText("Amount");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(Color.black);
        JLabel2.setBounds(12, 48, 48, 24);
        JTextField JTextField_NAME = new JTextField();
        JTextField_NAME.setEditable(false);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84, 12, 144, 24);
        okayButton.setText("OK");
        okayButton.setActionCommand("OK");
        getContentPane().add(okayButton);
        okayButton.setBounds(36, 84, 84, 24);
        cancelButton.setText("Cancel");
        cancelButton.setActionCommand("Cancel");
        getContentPane().add(cancelButton);
        cancelButton.setBounds(156, 84, 84, 24);
        getContentPane().add(depositTextField);
        depositTextField.setBounds(84, 48, 144, 24);
        JTextField_NAME.setText(accountNumber);

        SymAction lSymAction = new SymAction();
        okayButton.addActionListener(lSymAction);
        cancelButton.addActionListener(lSymAction);

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
        applicationForm.amountDeposit = depositTextField.getText();
        dispose();
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent event) {
        dispose();
    }

    /**
     * Force a contract to set title for the dialog
     */
    public abstract String getDialogTitle();

}
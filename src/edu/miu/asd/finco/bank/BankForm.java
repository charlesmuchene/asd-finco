package edu.miu.asd.finco.bank;

import edu.miu.asd.finco.framework.ui.ApplicationForm;
import edu.miu.asd.finco.framework.ui.dialogs.AccountDialog;

import javax.swing.*;
import java.awt.*;

public class BankForm extends ApplicationForm {

    public BankForm() {
        super("Bank Application", (jPanel, rectangle) -> {
            JButton addInterestButton = new JButton();
            addInterestButton.setBounds(448, 20, 106, 33);
            addInterestButton.setText("Add interest");
            jPanel.add(addInterestButton);
        });
        setAccountTypeFunctor(new AccountTypeFunctorImpl());
    }

    private static class AccountTypeFunctorImpl implements AccountDialog.AccountTypeFunctor {

        private JRadioButton checkingAccountRadioButton;

        @Override
        public void addUI(Container container) {
            checkingAccountRadioButton = new JRadioButton();
            checkingAccountRadioButton.setText("Checkings");
            checkingAccountRadioButton.setActionCommand("Checkings");
            container.add(checkingAccountRadioButton);
            checkingAccountRadioButton.setBounds(36, 12, 100, 24);
            JRadioButton savingsAccountRadioButton = new JRadioButton();
            savingsAccountRadioButton.setText("Savings");
            savingsAccountRadioButton.setActionCommand("Savings");
            container.add(savingsAccountRadioButton);
            savingsAccountRadioButton.setBounds(36, 36, 84, 24);
        }

        @Override
        public String getAccountType() {
            return checkingAccountRadioButton.isSelected() ? "Ch" : "S";
        }
    }
}

package edu.miu.asd.finco.bank;

import edu.miu.asd.finco.bank.controllers.AccountTypeController;
import edu.miu.asd.finco.bank.controllers.InterestController;
import edu.miu.asd.finco.bank.domain.AccountType;
import edu.miu.asd.finco.framework.ui.ApplicationForm;
import edu.miu.asd.finco.framework.ui.dialogs.AccountDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankForm extends ApplicationForm {
    private AccountTypeController accountTypeController;
    AccountTypeFunctorImpl accountTypeFunctor;

    public BankForm(InterestController interestController, AccountTypeController accountTypeController) {
        super("Bank Application", (jPanel, rectangle) -> {
            JButton addInterestButton = new JButton();
            addInterestButton.setBounds(448, 20, 106, 33);
            addInterestButton.setText("Add interest");
            addInterestButton.addActionListener(e -> interestController.addInterest());
            jPanel.add(addInterestButton);
        });

        this.accountTypeController = accountTypeController;
        accountTypeFunctor = new AccountTypeFunctorImpl(this.accountTypeController);
        setAccountTypeFunctor(accountTypeFunctor);

    }

    public static class AccountTypeFunctorImpl implements AccountDialog.AccountTypeFunctor {

        private JRadioButton checkingAccountRadioButton;

        public AccountTypeController accountTypeController;

        public AccountTypeFunctorImpl(AccountTypeController accountTypeController) {
            this.accountTypeController = accountTypeController;
        }

        @Override
        public void addUI(Container container) {
            checkingAccountRadioButton = new JRadioButton();
            checkingAccountRadioButton.setText("Checkings");
            checkingAccountRadioButton.setActionCommand("Checkings");
            container.add(checkingAccountRadioButton);
            checkingAccountRadioButton.setBounds(36, 12, 100, 24);
            checkingAccountRadioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accountTypeController.setAccountType(AccountType.CHECKING);
                }
            });
            JRadioButton savingsAccountRadioButton = new JRadioButton();
            savingsAccountRadioButton.setText("Savings");
            savingsAccountRadioButton.setActionCommand("Savings");
            savingsAccountRadioButton.setSelected(true);
            accountTypeController.setAccountType(AccountType.SAVINGS);
            container.add(savingsAccountRadioButton);
            savingsAccountRadioButton.setBounds(36, 36, 84, 24);
            savingsAccountRadioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accountTypeController.setAccountType(AccountType.SAVINGS);
                }
            });
        }

        @Override
        public String getAccountType() {
            return checkingAccountRadioButton.isSelected() ? "Ch" : "S";
        }
    }
}

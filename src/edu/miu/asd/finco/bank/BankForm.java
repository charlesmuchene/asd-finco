package edu.miu.asd.finco.bank;

import edu.miu.asd.finco.framework.ui.ApplicationForm;

import javax.swing.*;

public class BankForm extends ApplicationForm {

    public BankForm() {
        super("Bank Application", (jPanel, rectangle) -> {
            JButton addInterestButton = new JButton();
            addInterestButton.setBounds(448, 20, 106, 33);
            addInterestButton.setText("Add interest");
            jPanel.add(addInterestButton);
        });
    }
}

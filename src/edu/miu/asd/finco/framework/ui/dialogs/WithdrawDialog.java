package edu.miu.asd.finco.framework.ui.dialogs;

import edu.miu.asd.finco.framework.ui.ApplicationForm;

public class WithdrawDialog extends TransactionDialog {

    public WithdrawDialog(ApplicationForm parent, String accountNumber) {
        super(parent, accountNumber);
    }

    @Override
    public String getDialogTitle() {
        return "Withdraw";
    }
}
package edu.miu.asd.finco.framework.ui.dialogs;

import edu.miu.asd.finco.framework.ui.ApplicationForm;

public class DepositDialog extends TransactionDialog {

    public DepositDialog(ApplicationForm parent, String accountNumber) {
        super(parent, accountNumber);
    }

    @Override
    public String getDialogTitle() {
        return "Deposit";
    }
}

package edu.miu.asd.finco.bank;

import edu.miu.asd.finco.framework.FincoApplication;

public class BankApplication extends FincoApplication {

    private BankForm bankForm;

    public BankApplication() {
        super();
        this.bankForm = new BankForm();
        setApplicationForm(bankForm);
    }

    public static void main(String[] args) {
        BankApplication bankApplication = new BankApplication();
        bankApplication.launch();
    }

    public BankForm getBankForm() {
        return bankForm;
    }

}

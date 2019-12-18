package edu.miu.asd.finco.bank;

import edu.miu.asd.finco.bank.controllers.AccountTypeController;
import edu.miu.asd.finco.bank.controllers.InterestController;
import edu.miu.asd.finco.bank.domain.AccountType;
import edu.miu.asd.finco.bank.factories.BankAccountFactory;
import edu.miu.asd.finco.framework.FincoApplication;
import edu.miu.asd.finco.framework.controllers.AccountController;
import edu.miu.asd.finco.framework.factories.AbstractAccountFactory;

public class BankApplication extends FincoApplication {

    private BankForm bankForm;

    private BankAccountFactory bankAccountFactory;
    private AccountController accountController;

    public BankApplication() {
        super();

        bankAccountFactory = new BankAccountFactory();
        accountController = new AccountController(this.getDao(), bankAccountFactory);

        this.bankForm = new BankForm(new InterestController(getDao()), new AccountTypeController(bankAccountFactory));
        setApplicationForm(bankForm);

//        this.bankAccountFactory.setAccountType(AccountType.SAVINGS);

        this.setAccountFactory(bankAccountFactory);
        this.bankForm.setAccountController(this.accountController);

    }

    public static void main(String[] args) {
        BankApplication bankApplication = new BankApplication();
        bankApplication.launch();

        bankApplication.setApplicationExitFunctor(o -> {
            System.out.println("Accounts in application");
            System.out.println("-----------------------------");
            bankApplication.getDao().getAllAccounts().forEachRemaining(System.out::println);
            System.out.println("Application shutdown");
        });
    }

    public BankForm getBankForm() {
        return bankForm;
    }

}

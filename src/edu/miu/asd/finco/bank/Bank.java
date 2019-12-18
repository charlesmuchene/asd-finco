package edu.miu.asd.finco.bank;

import edu.miu.asd.finco.bank.controllers.AccountTypeController;
import edu.miu.asd.finco.bank.controllers.InterestController;
import edu.miu.asd.finco.bank.factories.BankAccountFactory;
import edu.miu.asd.finco.framework.Finco;
import edu.miu.asd.finco.framework.controllers.AccountController;

public class Bank extends Finco {

    private BankForm bankForm;

    private BankAccountFactory bankAccountFactory;
    private AccountController accountController;

    public Bank() {
        super();

        bankAccountFactory = new BankAccountFactory();
        accountController = new AccountController(this.getDao(), bankAccountFactory);

        this.bankForm = new BankForm(new InterestController(getDao()), new AccountTypeController(bankAccountFactory));
        setApplicationForm(bankForm);

        this.setAccountFactory(bankAccountFactory);
        this.bankForm.setAccountController(this.accountController);

    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.launch();

        bank.setApplicationExitFunctor(o -> {
            System.out.println("Accounts in application");
            System.out.println("-----------------------------");
            bank.getDao().getAllAccounts().forEachRemaining(System.out::println);
            System.out.println("Application shutdown");
        });
    }

    public BankForm getBankForm() {
        return bankForm;
    }

}

package edu.miu.asd.finco.framework.controllers;

import edu.miu.asd.finco.framework.dao.FincoDao;
import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.domain.IOrganization;
import edu.miu.asd.finco.framework.domain.ITransaction;
import edu.miu.asd.finco.framework.factories.AbstractTransactionFactory;

import java.util.Optional;
import java.util.OptionalDouble;

public class TransactionController {

    private FincoDao fincoDao;
    private AbstractTransactionFactory transactionFactory;

    public TransactionController(FincoDao fincoDao, AbstractTransactionFactory transactionFactory) {
        this.fincoDao = fincoDao;
        this.transactionFactory = transactionFactory;
    }

    /**
     * Make deposit
     *
     * @param amount        Amount to deposit
     * @param accountNumber Account number
     * @param description   Description
     * @return {@link OptionalDouble} instance
     */
    public OptionalDouble makeDeposit(String amount, String accountNumber, String description) {
        Optional<IAccount> optionalIAccount = fincoDao.findAccount(accountNumber);
        if (optionalIAccount.isPresent()) {

            IAccount account = optionalIAccount.get();

            try {

                double newAmount = Double.parseDouble(amount);
                ITransaction transaction = transactionFactory.createTransaction(ITransaction.Type.DEPOSIT, newAmount, description);
                account.executeTransaction(transaction);
                fincoDao.updateAccount(account);
                notifyCustomerWithAccount(account);
                return OptionalDouble.of(account.getBalance());

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return OptionalDouble.empty();
    }

    /**
     * Make withdraw
     *
     * @param amount        Amount to withdraw
     * @param accountNumber Account number
     * @param description   Description
     * @return {@link OptionalDouble} instance
     */
    public OptionalDouble makeWithdraw(String amount, String accountNumber, String description) {
        Optional<IAccount> optionalIAccount = fincoDao.findAccount(accountNumber);
        if (optionalIAccount.isPresent()) {

            IAccount account = optionalIAccount.get();

            try {

                double newAmount = Double.parseDouble(amount);
                ITransaction transaction = transactionFactory.createTransaction(ITransaction.Type.WITHDRAW, newAmount, description);
                account.executeTransaction(transaction);
                fincoDao.saveTransaction(transaction);
                fincoDao.updateAccount(account);
                notifyCustomerWithAccount(account);
                return OptionalDouble.of(account.getBalance());

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return OptionalDouble.empty();
    }

    /**
     * Email customer with the given account
     *
     * @param account {@link IAccount} instance
     */
    private void notifyCustomerWithAccount(IAccount account) {
        ICustomer customer = account.getCustomer();
        if (customer instanceof IOrganization)
            account.notifyCustomer();
    }
}

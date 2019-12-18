package edu.miu.asd.finco.framework.controllers;

import edu.miu.asd.finco.framework.dao.FincoDao;
import edu.miu.asd.finco.framework.domain.*;
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
                notifyCustomerWithAccount(account, newAmount);
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
                notifyCustomerWithAccount(account, newAmount);
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
     * @param amount  Amount in transaction
     */
    private void notifyCustomerWithAccount(IAccount account, double amount) {
        ICustomer customer = account.getCustomer();
        if (customer instanceof IOrganization) {
            account.notifyCustomer();
        } else if (customer instanceof IPerson || amount > 500 || account.getBalance() < 0) {
            account.notifyCustomer();
        }
    }
}

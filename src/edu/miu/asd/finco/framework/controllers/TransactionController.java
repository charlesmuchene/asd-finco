package edu.miu.asd.finco.framework.controllers;

import edu.miu.asd.finco.framework.dao.FincoDao;
import edu.miu.asd.finco.framework.domain.IAccount;
import edu.miu.asd.finco.framework.domain.IEntry;
import edu.miu.asd.finco.framework.factories.AbstractEntryFactory;

import java.util.Optional;
import java.util.OptionalDouble;

public class TransactionController {

    private FincoDao fincoDao;
    private AbstractEntryFactory entryFactory;

    public TransactionController(FincoDao fincoDao, AbstractEntryFactory entryFactory) {
        this.fincoDao = fincoDao;
        this.entryFactory = entryFactory;
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
                IEntry entry = entryFactory.createEntry(IEntry.Type.DEPOSIT, newAmount, description);
                account.executeEntry(entry);
                fincoDao.updateAccount(account);
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
                IEntry entry = entryFactory.createEntry(IEntry.Type.WITHDRAW, newAmount, description);
                account.executeEntry(entry);
                fincoDao.updateAccount(account);
                return OptionalDouble.of(account.getBalance());

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return OptionalDouble.empty();
    }
}

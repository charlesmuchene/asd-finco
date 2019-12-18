package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.ITransaction;

public interface AbstractTransactionFactory {

    /**
     * Create transaction of the given type
     *
     * @param type        {@link ITransaction.Type} instance
     * @param amount      Amount
     * @param description Description
     * @return {@link ITransaction} instance
     */
    ITransaction createTransaction(ITransaction.Type type, double amount, String description);

}

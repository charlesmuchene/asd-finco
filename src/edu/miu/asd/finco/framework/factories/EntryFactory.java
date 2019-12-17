package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.Deposit;
import edu.miu.asd.finco.framework.domain.IEntry;
import edu.miu.asd.finco.framework.domain.Withdraw;

public class EntryFactory implements AbstractEntryFactory {

    @Override
    public IEntry createEntry(IEntry.Type type, double amount, String description) {
        switch (type) {
            case DEPOSIT:
                return new Deposit(amount, description);
            case WITHDRAW:
                return new Withdraw(amount, description);
        }
        throw new IllegalArgumentException("Unknown type of IEntry");
    }
}

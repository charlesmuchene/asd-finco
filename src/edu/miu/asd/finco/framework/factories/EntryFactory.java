package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.Deposit;
import edu.miu.asd.finco.framework.domain.IEntry;

public class EntryFactory implements AbstractEntryFactory {
    @Override
    public IEntry createEntry() {
        return new Deposit();
    }
}

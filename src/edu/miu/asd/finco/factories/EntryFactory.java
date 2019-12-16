package edu.miu.asd.finco.factories;

import edu.miu.asd.finco.domain.Deposit;
import edu.miu.asd.finco.domain.IEntry;

public class EntryFactory implements AbstractEntryFactory {
    @Override
    public IEntry createEntry() {
        return new Deposit();
    }
}

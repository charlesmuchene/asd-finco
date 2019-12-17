package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.IEntry;

public interface AbstractEntryFactory {

    /**
     * Create entry of the given type
     *
     * @param type        {@link IEntry.Type} instance
     * @param amount      Amount
     * @param description Description
     * @return {@link IEntry} instance
     */
    IEntry createEntry(IEntry.Type type, double amount, String description);

}

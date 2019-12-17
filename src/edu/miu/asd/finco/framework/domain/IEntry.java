package edu.miu.asd.finco.framework.domain;

public interface IEntry {

    enum Type {DEPOSIT, WITHDRAW}

    /**
     * Execute this entry
     */
    void execute();

}

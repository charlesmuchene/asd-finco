package edu.miu.asd.finco.domain;

public interface IEntry {
    enum Type {DEPOSIT, WITHDRAW}

    void execute();
}

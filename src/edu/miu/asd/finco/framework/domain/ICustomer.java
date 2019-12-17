package edu.miu.asd.finco.framework.domain;

public interface ICustomer {

    enum Type {ORGANIZATION, PERSON}

    void addAccount(IAccount account);

    void removeAccount(IAccount account);
}

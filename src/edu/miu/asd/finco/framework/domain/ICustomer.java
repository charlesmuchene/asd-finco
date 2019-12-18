package edu.miu.asd.finco.framework.domain;

public interface ICustomer {

    enum Type {

        ORGANIZATION("C"), PERSON("P");

        public String initials;

        Type(String initials) {
            this.initials = initials;
        }
    }

    void addAccount(IAccount account);

    void removeAccount(IAccount account);
}

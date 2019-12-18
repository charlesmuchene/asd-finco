package edu.miu.asd.finco.framework.domain;

import java.time.LocalDate;
import java.util.List;

public class Person extends Customer implements IOrganization {
    private LocalDate birthDate;
    private IOrganization employer;

    public Person(String name, String street, String city, String zip,
                  String state, String email, LocalDate birthDate) {

        super(name, street, city, zip, state, email);
        this.birthDate = birthDate;
    }
}

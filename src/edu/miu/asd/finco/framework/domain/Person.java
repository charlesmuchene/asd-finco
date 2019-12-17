package edu.miu.asd.finco.framework.domain;

import java.time.LocalDate;

public class Person extends Customer implements IOrganization {
    private LocalDate birthDate;
    private IOrganization employer;

}

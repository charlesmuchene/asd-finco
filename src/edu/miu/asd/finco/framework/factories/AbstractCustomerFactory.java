package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.ICustomer;

import java.time.LocalDate;

public interface AbstractCustomerFactory {

    ICustomer createCustomer(ICustomer.Type type, String name, String street, String city, String zip, String state, String email, int nOfEmployees, LocalDate birthDate);

}

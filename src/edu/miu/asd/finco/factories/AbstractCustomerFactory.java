package edu.miu.asd.finco.factories;

import edu.miu.asd.finco.domain.ICustomer;

public interface AbstractCustomerFactory {
    ICustomer createCustomer();
}

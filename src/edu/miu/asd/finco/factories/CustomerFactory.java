package edu.miu.asd.finco.factories;

import edu.miu.asd.finco.domain.ICustomer;
import edu.miu.asd.finco.domain.Organization;

public class CustomerFactory implements AbstractCustomerFactory {
    @Override
    public ICustomer createCustomer() {
        return new Organization();
    }
}

package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.ICustomer;
import edu.miu.asd.finco.framework.domain.Organization;

public class CustomerFactory implements AbstractCustomerFactory {
    @Override
    public ICustomer createCustomer() {
        return new Organization();
    }
}

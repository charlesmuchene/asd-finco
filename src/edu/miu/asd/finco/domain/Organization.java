package edu.miu.asd.finco.domain;

import java.util.ArrayList;
import java.util.List;

public class Organization extends Customer implements IOrganization {
    private int nOfEmployees;
    private List<IPerson> employees = new ArrayList<>();
}

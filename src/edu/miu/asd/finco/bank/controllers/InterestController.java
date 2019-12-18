package edu.miu.asd.finco.bank.controllers;

import edu.miu.asd.finco.framework.dao.FincoDao;
import edu.miu.asd.finco.framework.domain.IAccount;

import java.util.Iterator;

public class InterestController
{
    private FincoDao fincodao;
    Iterator<IAccount> itAccount;

    public InterestController(FincoDao fincodao) {
        this.fincodao = fincodao;
    }

    public void addInterest()
    {
        fincodao.getAllAccounts().forEachRemaining(IAccount::addInterest);

    }

}

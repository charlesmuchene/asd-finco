package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.Card;
import edu.miu.asd.finco.framework.domain.FinCoAccount;
import edu.miu.asd.finco.framework.domain.FinCoCard;
import edu.miu.asd.finco.framework.domain.IAccount;

public class AccountFactory implements AbstractAccountFactory {
    @Override
    public IAccount createAccount() {
        return new FinCoAccount();
    }

    @Override
    public Card createCard() {
        return new FinCoCard();
    }
}

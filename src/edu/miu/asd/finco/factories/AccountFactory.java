package edu.miu.asd.finco.factories;

import edu.miu.asd.finco.domain.Card;
import edu.miu.asd.finco.domain.FinCoAccount;
import edu.miu.asd.finco.domain.FinCoCard;
import edu.miu.asd.finco.domain.IAccount;

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

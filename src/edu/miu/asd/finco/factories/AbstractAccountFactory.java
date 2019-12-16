package edu.miu.asd.finco.factories;

import edu.miu.asd.finco.domain.Card;
import edu.miu.asd.finco.domain.IAccount;

public interface AbstractAccountFactory {
    IAccount createAccount();
    Card createCard();
}

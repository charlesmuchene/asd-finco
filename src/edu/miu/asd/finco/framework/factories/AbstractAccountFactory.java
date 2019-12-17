package edu.miu.asd.finco.framework.factories;

import edu.miu.asd.finco.framework.domain.Card;
import edu.miu.asd.finco.framework.domain.IAccount;

public interface AbstractAccountFactory {
    IAccount createAccount();
    Card createCard();
}

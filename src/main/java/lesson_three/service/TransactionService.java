package lesson_three.service;

import lesson_three.entity.Client;
import lesson_three.util.AccountParamsCheckerHelper;

public class TransactionService {

    public void moneyTransfer (Client client, String accountID){
        AccountParamsCheckerHelper accountParamsCheckerHelper = new AccountParamsCheckerHelper();
        accountParamsCheckerHelper.checkIDsEquality(client.getAccountID(), accountID);
    }
}

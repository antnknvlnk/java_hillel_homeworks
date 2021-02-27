package lesson_three.util;

import lesson_three.exception.UserExpectedError;
import lesson_three.exception.WrongFieldException;
import lesson_three.exception.WrongSumException;

public class AccountParamsCheckerHelper {

    public void checkIDSize (String accountID) throws WrongFieldException {
        if (accountID.length() < 10){
            throw new WrongFieldException();
        }
    }

    public void checkAmount (float Sum) throws WrongSumException {
        if (Sum < 1000f){
            throw new WrongSumException();
        }
    }

    public void checkIDsEquality (String clientWhoSendsID, String clientWhoReceivesID) throws UserExpectedError {
        if (!(clientWhoSendsID.equals(clientWhoReceivesID))) {
            throw new UserExpectedError();
        }
    }
}

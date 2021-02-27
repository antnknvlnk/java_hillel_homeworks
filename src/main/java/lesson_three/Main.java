package lesson_three;

import lesson_three.entity.Client;
import lesson_three.exception.WrongFieldException;
import lesson_three.exception.WrongSumException;
import lesson_three.service.TransactionService;
import lesson_three.util.AccountParamsCheckerHelper;

import java.util.Scanner;

public class Main {

    private static AccountParamsCheckerHelper accountParamsCheckerHelper = new AccountParamsCheckerHelper();

    public static void main(String[] args) {

        Client client1 = new Client();
        Client client2 = new Client();

        System.out.println("Please, enter client's that send account ID: ");
        enterClientAccountID(client1);
        System.out.println("Please, enter client's that receive account ID: ");
        enterClientAccountID(client2);
        System.out.println("Please, enter the transfer amount: ");
        enterTransferAmount(client1);

        TransactionService transactionService = new TransactionService();

        transactionService.moneyTransfer(client1, client2.getAccountID());
        System.out.println("Transfer SUCCESS");
    }

    public static void enterClientAccountID (Client client){
        Scanner in = new Scanner(System.in);
        String accountID;
        while (true) {
            try {
                accountID = in.next();
                accountParamsCheckerHelper.checkIDSize(accountID);
                client.setAccountID(accountID);
                break;
            } catch (WrongFieldException e) {
                System.out.println("Wrong account ID, please, try again: ");
            }
        }
    }

    public static void enterTransferAmount (Client client){
        Scanner in = new Scanner(System.in);
        float transferAmount;
        while (true) {
            try {
                transferAmount = Float.parseFloat(in.next());
                accountParamsCheckerHelper.checkAmount(transferAmount);
                client.setAmount(transferAmount);
                break;
            } catch (WrongSumException e) {
                System.out.println("Amount should be more than 1000, please, try again: ");
            }
        }
    }
}

package lesson_five;

import lesson_five.database.Database;
import lesson_five.entity.Account;
import lesson_five.entity.Client;
import lesson_five.entity.Status;
import lesson_five.service.AccountService;
import lesson_five.service.ClientService;
import lesson_five.service.StatusService;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        System.out.println(clientService.getClientByPhone(380999128745L));
        System.out.println(clientService.getClientsWithIdAppearedInAccounts());
        System.out.println(clientService.getClientsStatusWithAgeMoreThan18());

        AccountService accountService = new AccountService();
        List<String> numbers = accountService.getNumbersMoreThanValue(1000D);

        StatusService statusService = new StatusService();
        List<Status> statuses = statusService.getAll();

    }
}

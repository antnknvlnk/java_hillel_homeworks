package lesson_eight.service;

import lesson_eight.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll();
    Account findById(int id);
    void save(Account account);
    void update(Account account);
    void delete(Account account);
}

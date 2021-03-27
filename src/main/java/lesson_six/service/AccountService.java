package lesson_six.service;

import lesson_six.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll();
    Account findById(int id);
    void save(Account account);
    void update(Account account);
    void delete(Account account);
}

package lesson_six.dao;

import lesson_six.model.Account;

import java.util.List;

public interface AccountDao {
    List<Account> getAll();
    Account findById(int id);
    void save(Account account);
    void update(Account account);
    void delete (Account account);
}

package lesson_six.service;

import lesson_six.dao.AccountDao;
import lesson_six.dao.AccountDaoImpl;
import lesson_six.model.Account;

import java.util.List;

public class AccountServiceImpl implements AccountService{
    @Override
    public List<Account> getAll() {
        AccountDao accountDao = new AccountDaoImpl();
        return accountDao.getAll();
    }

    @Override
    public Account findById(int id) {
        AccountDao accountDao = new AccountDaoImpl();
        return accountDao.findById(id);
    }

    @Override
    public void save(Account account) {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.update(account);
    }

    @Override
    public void delete(Account account) {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.delete(account);
    }
}

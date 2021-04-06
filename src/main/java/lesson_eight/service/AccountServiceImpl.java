package lesson_eight.service;

import lesson_eight.dao.AccountDao;
import lesson_eight.dao.AccountDaoImpl;
import lesson_eight.model.Account;
import org.apache.log4j.Logger;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    Logger logger = Logger.getLogger(AccountServiceImpl.class);

    @Override
    public List<Account> getAll() {
        AccountDao accountDao = new AccountDaoImpl();
        return accountDao.getAll();
    }

    @Override
    public Account findById(int id) {
        logger.debug(id);
        AccountDao accountDao = new AccountDaoImpl();
        return accountDao.findById(id);
    }

    @Override
    public void save(Account account) {
        logger.debug(account.toString());
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        logger.debug(account.toString());
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.update(account);
    }

    @Override
    public void delete(Account account) {
        logger.debug(account.toString());
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.delete(account);
    }
}

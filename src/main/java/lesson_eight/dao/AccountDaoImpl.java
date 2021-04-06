package lesson_eight.dao;

import lesson_eight.dao.AccountDao;
import lesson_eight.model.Account;
import lesson_eight.service.AccountServiceImpl;
import lesson_eight.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class AccountDaoImpl implements  AccountDao {

    Logger logger = Logger.getLogger(AccountDaoImpl.class);

    @Override
    public List<Account> getAll() {
        return (List<Account>) HibernateUtil.getSessionFactory().openSession().createQuery("FROM lesson_eight.model.Account").list();
    }

    @Override
    public Account findById(int id) {
        logger.debug(id);
        return HibernateUtil.getSessionFactory().openSession().get(Account.class, id);
    }

    @Override
    public void save(Account account) {
        logger.debug(account.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Account account) {
        logger.debug(account.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("UPDATE lesson_eight.model.Account " +
                "SET clientId = :clientId, number = :number, value = :value WHERE id = :id");

        query.setParameter("id", account.getId());
        query.setParameter("clientId", account.getClientId());
        query.setParameter("number", account.getNumber());
        query.setParameter("value", account.getValue());
        query.executeUpdate();

        session.update(account);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Account account) {
        logger.debug(account.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE lesson_eight.model.Account WHERE number = :number");

        query.setParameter("number", account.getNumber());
        query.executeUpdate();

        session.delete(account);
        transaction.commit();
        session.close();
    }
}

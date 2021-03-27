package lesson_six.dao;

import lesson_six.model.Account;
import lesson_six.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class AccountDaoImpl implements  AccountDao {
    @Override
    public List<Account> getAll() {
        return (List<Account>) HibernateUtil.getSessionFactory().openSession().createQuery("FROM lesson_six.model.Account").list();
    }

    @Override
    public Account findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Account.class, id);
    }

    @Override
    public void save(Account account) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Account account) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("UPDATE lesson_six.model.Account " +
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
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE lesson_six.model.Account WHERE number = :number");

        query.setParameter("number", account.getNumber());
        query.executeUpdate();

        session.delete(account);
        transaction.commit();
        session.close();
    }
}

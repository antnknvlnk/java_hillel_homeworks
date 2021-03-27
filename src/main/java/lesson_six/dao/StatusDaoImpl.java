package lesson_six.dao;

import lesson_six.model.Status;
import lesson_six.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class StatusDaoImpl implements  StatusDao{
    @Override
    public List<Status> getAll() {
        return (List<Status>) HibernateUtil.getSessionFactory().openSession().createQuery("FROM lesson_six.model.Status").list();
    }

    @Override
    public Status findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Status.class, id);
    }

    @Override
    public void save(Status status) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(status);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Status status) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("UPDATE lesson_six.model.Status " +
                "SET alias = :alias, description = :description WHERE id = :id");

        query.setParameter("id", status.getId());
        query.setParameter("alias", status.getAlias());
        query.setParameter("description", status.getDescription());
        query.executeUpdate();

        session.update(status);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Status status) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE lesson_six.model.Status WHERE alias = :alias");

        query.setParameter("alias", status.getAlias());
        query.executeUpdate();

        session.delete(status);
        transaction.commit();
        session.close();
    }
}

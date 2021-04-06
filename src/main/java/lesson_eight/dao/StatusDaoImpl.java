package lesson_eight.dao;

import lesson_eight.util.HibernateUtil;
import lesson_eight.model.Status;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class StatusDaoImpl implements StatusDao {

    Logger logger = Logger.getLogger(StatusDaoImpl.class);

    @Override
    public List<lesson_eight.model.Status> getAll() {
        return (List<lesson_eight.model.Status>) lesson_eight.util.HibernateUtil.getSessionFactory().openSession().createQuery("FROM lesson_eight.model.Status").list();
    }

    @Override
    public lesson_eight.model.Status findById(int id) {
        logger.debug(id);
        return HibernateUtil.getSessionFactory().openSession().get(Status.class, id);
    }

    @Override
    public void save(Status status) {
        logger.debug(status.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(status);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Status status) {
        logger.debug(status.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("UPDATE lesson_eight.model.Status " +
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
        logger.debug(status.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE lesson_eight.model.Status WHERE alias = :alias");

        query.setParameter("alias", status.getAlias());
        query.executeUpdate();

        session.delete(status);
        transaction.commit();
        session.close();
    }
}

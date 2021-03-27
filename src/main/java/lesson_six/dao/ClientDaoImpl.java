package lesson_six.dao;

import lesson_six.model.Client;
import lesson_six.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ClientDaoImpl implements ClientDao{
    @Override
    public List<Client> getAll() {
        return (List<Client>) HibernateUtil.getSessionFactory().openSession().createQuery("FROM lesson_six.model.Client").list();
    }

    @Override
    public Client findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().byId(Client.class).getReference(id);
    }

    @Override
    public List<Client> findByPhone(long phone) {
        Query query = HibernateUtil.getSessionFactory().openSession().createQuery("FROM lesson_six.model.Client WHERE phone = :phone");
        query.setParameter("phone", phone);
        return (List<Client>) query.getResultList();
    }

    @Override
    public void save(Client client) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Client client) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("UPDATE lesson_six.model.Client " +
                "SET name = :name, email = :email, phone = :phone, about = :about, age = :age WHERE id = :id");

        query.setParameter("id", client.getId());
        query.setParameter("name", client.getName());
        query.setParameter("email", client.getEmail());
        query.setParameter("phone", client.getPhone());
        query.setParameter("about", client.getAbout());
        query.setParameter("age", client.getAge());
        query.executeUpdate();

        session.update(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Client client) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE lesson_six.model.Client WHERE email = :email");

        query.setParameter("email", client.getEmail());
        query.executeUpdate();

        session.delete(client);
        transaction.commit();
        session.close();
    }
}

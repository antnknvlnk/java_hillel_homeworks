package lesson_seven;

import lesson_seven.domain.Account;
import lesson_seven.domain.Cource;
import lesson_seven.domain.Status;
import lesson_seven.util.HibernateUtil;
import lesson_seven.domain.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        Client client = new Client();
        client.setName("Anton");
        client.setEmail("anton@email.com");
        client.setAge(26);
        client.setPhone(380939128189L);
        client.setAbout("Test...");

        Account account = new Account();
        account.setClient(client);
        account.setNumber("12141312413");
        account.setValue(5554);

        Cource cource = new Cource();
        cource.setName("Java");
        cource.setPrice(10000);

        Status status = new Status();
        status.setClient(client);
        status.setAlias("VIP");
        status.setDescription("Vip client");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(account);
        session.save(client);
        session.save(status);
        session.save(cource);
        session.close();


    }
}

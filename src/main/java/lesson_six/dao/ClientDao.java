package lesson_six.dao;

import lesson_six.model.Client;

import java.util.List;

public interface ClientDao {
    List<Client> getAll();
    Client findById(int id);
    List<Client> findByPhone(long phone);
    void save(Client client);
    void update(Client client);
    void delete (Client client);

}

package lesson_eight.service;

import lesson_eight.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAll();
    Client findById(int id);
    List<Client> findByPhone(long phone);
    void save(Client client);
    void update(Client client);
    void delete(Client client);
}

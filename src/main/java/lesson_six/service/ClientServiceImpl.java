package lesson_six.service;

import lesson_six.dao.ClientDao;
import lesson_six.dao.ClientDaoImpl;
import lesson_six.model.Client;

import java.util.List;

public class ClientServiceImpl implements ClientService{
    @Override
    public List<Client> getAll() {
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.getAll();
    }

    @Override
    public Client findById(int id) {
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.findById(id);
    }

    @Override
    public List<Client> findByPhone(long phone) {
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.findByPhone(phone);
    }

    @Override
    public void save(Client client) {
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.save(client);
    }

    @Override
    public void update(Client client) {
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.update(client);
    }

    @Override
    public void delete(Client client) {
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.delete(client);
    }
}

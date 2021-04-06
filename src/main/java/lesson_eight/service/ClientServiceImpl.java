package lesson_eight.service;

import lesson_eight.dao.ClientDao;
import lesson_eight.dao.ClientDaoImpl;
import lesson_eight.model.Client;
import lesson_eight.service.ClientService;
import org.apache.log4j.Logger;

import java.util.List;

public class ClientServiceImpl implements ClientService{

    Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Override
    public List<Client> getAll() {
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.getAll();
    }

    @Override
    public Client findById(int id) {
        logger.debug(id);
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.findById(id);
    }

    @Override
    public List<Client> findByPhone(long phone) {
        logger.debug(phone);
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.findByPhone(phone);
    }

    @Override
    public void save(Client client) {
        logger.debug(client.toString());
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.save(client);
    }

    @Override
    public void update(Client client) {
        logger.debug(client.toString());
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.update(client);
    }

    @Override
    public void delete(Client client) {
        logger.debug(client.toString());
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.delete(client);
    }
}

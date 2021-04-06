package lesson_eight.service;

import lesson_eight.dao.StatusDao;
import lesson_eight.dao.StatusDaoImpl;
import lesson_eight.model.Status;
import org.apache.log4j.Logger;

import java.util.List;

public class StatusServiceImpl implements StatusService {

    Logger logger = Logger.getLogger(StatusServiceImpl.class);

    @Override
    public List<Status> getAll() {
       StatusDao statusDao = new StatusDaoImpl();
        return statusDao.getAll();
    }

    @Override
    public Status findById(int id) {
        logger.debug(id);
        StatusDao statusDao = new StatusDaoImpl();
        return statusDao.findById(id);
    }

    @Override
    public void save(Status status) {
        logger.debug(status.toString());
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.save(status);
    }

    @Override
    public void update(Status status) {
        logger.debug(status.toString());
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.update(status);
    }

    @Override
    public void delete(Status status) {
        logger.debug(status.toString());
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.delete(status);
    }
}

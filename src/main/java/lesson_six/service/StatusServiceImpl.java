package lesson_six.service;

import lesson_six.dao.StatusDao;
import lesson_six.dao.StatusDaoImpl;
import lesson_six.model.Status;

import java.util.List;

public class StatusServiceImpl implements StatusService{
    @Override
    public List<Status> getAll() {
        StatusDao statusDao = new StatusDaoImpl();
        return statusDao.getAll();
    }

    @Override
    public Status findById(int id) {
        StatusDao statusDao = new StatusDaoImpl();
        return statusDao.findById(id);
    }

    @Override
    public void save(Status status) {
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.save(status);
    }

    @Override
    public void update(Status status) {
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.update(status);
    }

    @Override
    public void delete(Status status) {
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.delete(status);
    }
}

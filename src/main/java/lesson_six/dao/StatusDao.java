package lesson_six.dao;

import lesson_six.model.Status;

import java.util.List;

public interface StatusDao {
    List<Status> getAll();
    Status findById(int id);
    void save(Status status);
    void update(Status status);
    void delete (Status status);
}

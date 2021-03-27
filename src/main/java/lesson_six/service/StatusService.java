package lesson_six.service;

import lesson_six.model.Status;

import java.util.List;

public interface StatusService {
    List<Status> getAll();
    Status findById(int id);
    void save(Status status);
    void update(Status status);
    void delete(Status status);
}

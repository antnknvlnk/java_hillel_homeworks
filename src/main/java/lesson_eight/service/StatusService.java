package lesson_eight.service;

import lesson_eight.model.Status;

import java.util.List;

public interface StatusService {
    List<lesson_eight.model.Status> getAll();
    lesson_eight.model.Status findById(int id);
    void save(lesson_eight.model.Status status);
    void update(lesson_eight.model.Status status);
    void delete(Status status);
}

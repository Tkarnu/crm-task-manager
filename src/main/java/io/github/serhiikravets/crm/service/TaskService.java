package io.github.serhiikravets.crm.service;
import io.github.serhiikravets.crm.entity.Task;
import io.github.serhiikravets.crm.entity.User;
import io.github.serhiikravets.crm.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findByUser(User user) {
        return taskRepository.findByUser(user);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
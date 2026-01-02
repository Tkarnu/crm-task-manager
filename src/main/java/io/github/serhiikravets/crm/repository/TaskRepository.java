package io.github.serhiikravets.crm.repository;

import io.github.serhiikravets.crm.entity.Task;
import io.github.serhiikravets.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
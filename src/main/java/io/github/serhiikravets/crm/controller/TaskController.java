package io.github.serhiikravets.crm.controller;

import io.github.serhiikravets.crm.entity.Task;
import io.github.serhiikravets.crm.entity.User;
import io.github.serhiikravets.crm.service.TaskService;
import io.github.serhiikravets.crm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @GetMapping("/tasks")
    public String tasks(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("tasks", taskService.findByUser(user));
        model.addAttribute("task", new Task());
        return "tasks";
    }

    @PostMapping("/tasks")
    public String create(Task task, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        task.setUser(user);
        taskService.save(task);
        return "redirect:/tasks";
    }
}

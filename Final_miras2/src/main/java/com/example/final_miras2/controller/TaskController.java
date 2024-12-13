package com.example.final_miras2.controller;

import com.example.final_miras2.model.Task;
import com.example.final_miras2.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String listTasks(@RequestParam(value = "category", required = false) String category, Model model) {
        List<Task> tasks;
        if (category == null || category.isEmpty()) {
            tasks = taskService.findAll();
        } else {
            tasks = taskService.findByCategory(category);
        }

        model.addAttribute("tasks", tasks);
        model.addAttribute("selectedCategory", category != null ? category : "");
        return "tasks";
    }
}
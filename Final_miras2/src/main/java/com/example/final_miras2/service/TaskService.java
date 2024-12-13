package com.example.final_miras2.service;

import com.example.final_miras2.model.Task;
import com.example.final_miras2.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task> findByCategory(String category) {
        return taskRepository.findByCategory(category);
    }
}
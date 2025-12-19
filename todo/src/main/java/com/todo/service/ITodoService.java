package com.todo.service;

import com.todo.entity.Tasks;
import com.todo.entity.enums.TaskStatus;

import java.util.List;

public interface ITodoService {
    Tasks addTask(String name , String description);
    List<Tasks> getAllTasks();
    String updateStatus(Long id , TaskStatus taskStatus);
    Tasks updateTask(Long id, String taskName , String taskDescription);
   String deleteTask(Long id);
}

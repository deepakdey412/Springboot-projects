package com.todo.service.impl;

import com.todo.entity.Tasks;
import com.todo.entity.enums.TaskStatus;
import com.todo.repository.TodoRepository;
import com.todo.service.ITodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements ITodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Tasks addTask(String name , String description) {
        Tasks savedTask = new Tasks();
        savedTask.setTaskName(name);
        savedTask.setTaskDescription(description);
        savedTask.setTaskStatus(TaskStatus.PENDING);
        return todoRepository.save(savedTask);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return todoRepository.findAll();
    }

    @Override
    public String updateStatus(Long id, TaskStatus status) {
        Tasks foundTask = todoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Task not found with this id : "+ id));
        foundTask.setTaskStatus(status);
        todoRepository.save(foundTask);
        return "Task STATUS updated";
    }

    @Override
    public Tasks updateTask(Long id, String taskName, String taskDescription) {

        Tasks task = todoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found with id: " + id));

        if (task.getTaskStatus() == TaskStatus.COMPLETED) {
            throw new IllegalStateException(
                    "Completed task cannot be updated");
        }

        task.setTaskName(taskName);
        task.setTaskDescription(taskDescription);

        return todoRepository.save(task);
    }


    @Override
    public String deleteTask(Long id) {
        Tasks foundTask = todoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found with this id : "+ id));
        todoRepository.delete(foundTask);
        return "Task deleted";
    }
}

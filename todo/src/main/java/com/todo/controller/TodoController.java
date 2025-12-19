package com.todo.controller;

import com.todo.entity.Tasks;
import com.todo.entity.enums.TaskStatus;
import com.todo.service.ITodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    private final ITodoService todoService;

    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/add")
    public ResponseEntity<Tasks> addNewTask(@RequestParam String name , @RequestParam String description) {
        Tasks savedTask = todoService.addTask(name , description);
        return ResponseEntity.ok(savedTask);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Tasks>> getAllTasks() {
        return new ResponseEntity<>(
                todoService.getAllTasks(),
                HttpStatus.OK);
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<String> updateTaskStatus(
            @PathVariable Long id,
            @RequestParam TaskStatus status
    ) {
        String updatedStatus = todoService.updateStatus(id, status);
        return ResponseEntity.ok(updatedStatus);
    }

    @PutMapping("/updateTask/{id}")
    public ResponseEntity<Tasks> updateTheTask(
            @PathVariable Long id,
            @RequestParam String taskName,
            @RequestParam String taskDescription
    ) {
        Tasks updatedTask = todoService.updateTask(id, taskName, taskDescription);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.deleteTask(id));
    }
}

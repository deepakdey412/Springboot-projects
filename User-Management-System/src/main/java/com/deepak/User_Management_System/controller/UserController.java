package com.deepak.User_Management_System.controller;

import com.deepak.User_Management_System.dto.RequestDto;
import com.deepak.User_Management_System.dto.ResponseDto;
import com.deepak.User_Management_System.service.IUserService;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createUser(@RequestBody RequestDto requestDto) {
        return new ResponseEntity<ResponseDto>(
                userService.createUser(requestDto),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseDto>> getAllUser(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User has been deleted", HttpStatus.OK);
    }
}

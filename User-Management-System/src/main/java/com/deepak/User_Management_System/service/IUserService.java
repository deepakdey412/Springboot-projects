package com.deepak.User_Management_System.service;

import com.deepak.User_Management_System.dto.RequestDto;
import com.deepak.User_Management_System.dto.ResponseDto;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    ResponseDto createUser(RequestDto requestDto);
    List<ResponseDto> getUsers();
    void deleteUser(UUID id);
}

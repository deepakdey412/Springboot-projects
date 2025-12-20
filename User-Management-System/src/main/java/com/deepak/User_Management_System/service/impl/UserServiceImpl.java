package com.deepak.User_Management_System.service.impl;

import com.deepak.User_Management_System.dto.RequestDto;
import com.deepak.User_Management_System.dto.ResponseDto;
import com.deepak.User_Management_System.entity.Users;
import com.deepak.User_Management_System.mapper.DtoMapper;
import com.deepak.User_Management_System.repository.UserRepository;
import com.deepak.User_Management_System.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final DtoMapper dtoMapper;

    public UserServiceImpl(UserRepository userRepository, DtoMapper dtoMapper) {
        this.userRepository = userRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public ResponseDto createUser(RequestDto requestDto) {
        Users newUser = dtoMapper.toEntity(requestDto);
        Users savedUser = userRepository.save(newUser);
        return dtoMapper.toDto(savedUser);
    }

    @Override
    public List<ResponseDto> getUsers() {
        List<Users> users = userRepository.findAll();
        List<ResponseDto> responseDtoList = new ArrayList<>();
        for (Users user : users) {
            responseDtoList.add(dtoMapper.toDto(user));
        }
        return responseDtoList;
    }

    @Override
    public void deleteUser(UUID id) {
        Users foundUser = userRepository.findById(id).orElseThrow(
                ()->  new RuntimeException("User not found")
        );
        if (foundUser != null) {
            userRepository.delete(foundUser);
        }
    }
}

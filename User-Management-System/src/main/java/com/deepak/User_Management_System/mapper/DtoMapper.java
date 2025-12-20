package com.deepak.User_Management_System.mapper;

import com.deepak.User_Management_System.dto.RequestDto;
import com.deepak.User_Management_System.dto.ResponseDto;
import com.deepak.User_Management_System.entity.Users;
import com.deepak.User_Management_System.entity.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {
    public ResponseDto toDto(Users users) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setId(users.getId().toString());
        responseDto.setUsername(users.getUsername());
        responseDto.setEmail(users.getEmail());
        responseDto.setRole(users.getRole().name());
        return responseDto;
    }

    public Users toEntity(RequestDto requestDto) {
        Users users = new Users();
        users.setUsername(requestDto.getUsername());
        users.setEmail(requestDto.getEmail());
        users.setPassword(requestDto.getPassword());

        //This will check the exact value from the enum role
        // it input is "manager" which is not in the role then it will throw the exception
        // if we use the validation , it will only check the not blank and not null but not the role enum values ⬇️

        try {
            users.setRole(Role.valueOf(requestDto.getRole().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Role" + requestDto.getRole());
        }
        return users;
    }
}

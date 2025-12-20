package com.deepak.User_Management_System.mapper;

import com.deepak.User_Management_System.dto.RequestDto;
import com.deepak.User_Management_System.dto.ResponseDto;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {
    public ResponseDto toDto(RequestDto requestDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setUsername(requestDto.getUsername());

    }
}

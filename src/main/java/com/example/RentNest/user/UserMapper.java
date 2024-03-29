package com.example.RentNest.user;

import com.example.RentNest.user.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User map(UserResponse request);

    UserResponse map(User entity);

    List<UserResponse> mapList(List<User> entityList);
}

package com.udemy.register.controller.mapper;

import com.udemy.register.controller.request.UserRequest;
import com.udemy.register.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toUser(UserRequest request);
}

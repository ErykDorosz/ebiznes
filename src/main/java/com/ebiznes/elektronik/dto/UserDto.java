package com.ebiznes.elektronik.dto;

import com.ebiznes.elektronik.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private final Long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final boolean isAdmin;

    public static UserDto of(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getEmail())
                .firstName(user.getName())
                .lastName(user.getSurname())
                .isAdmin(user.isAdmin())
                .build();
    }
}

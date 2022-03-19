package com.ebiznes.elektronik.dto;

import com.ebiznes.elektronik.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class UserDto {
    private final Long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final boolean admin;

    public static UserDto of(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getEmail())
                .firstName(user.getName())
                .lastName(user.getSurname())
                .admin(user.isAdmin())
                .build();
    }
}

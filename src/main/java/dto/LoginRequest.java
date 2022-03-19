package dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginRequest
{
    @NotBlank
    private final String username;
    @NotBlank
    private final String password;
}

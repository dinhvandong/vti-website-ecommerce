package com.vti.demorestfulapi.payload.request;

import lombok.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NonNull
    @Size(min = 3, max = 100)
    private String username;
    @NonNull
    @Size(min = 6, max = 20)
    private String password;


}

package com.example.waupetshop.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.servlet.http.Cookie;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    @NotBlank
    private String message;

    private Cookie cookie;

}

package com.example.waupetshop.controller;

import com.example.waupetshop.dto.UserDto;
import com.example.waupetshop.payload.request.LoginRequest;
import com.example.waupetshop.payload.response.LoginResponse;
import com.example.waupetshop.security.JwtTokenProvider;
import com.example.waupetshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@CrossOrigin(value = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@SessionAttributes("userLogged")
public class AuthController {
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider tokenProvider;

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest, HttpSession session, HttpServletResponse response) {
        try {
            // Gọi hàm authenticate để xác thực thông tin đăng nhập
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Gọi hàm tạo Token
            String token = tokenProvider.generateToken(authentication);
            Cookie cookie = new Cookie("accessToken", token);
            cookie.setMaxAge(7 * 24 * 60 * 60);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            session.setAttribute("userLogged", userService.findByEmail(loginRequest.getEmail()));
            return new ResponseEntity<>(new LoginResponse("Đăng nhập thành công!", cookie), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new LoginResponse("Đăng nhập thất bại!", null), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.save(userDto);


        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

}

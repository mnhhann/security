package com.example.security.api;

import com.example.security.model.LoginRequest;
import com.example.security.model.LoginResponse;
import com.example.security.security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtIssuer jwtIssuer;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        var requestbuilder = JwtIssuer.Request.builder()
                .userId(1L)
                .userName(request.getUsername())
                .roles(List.of("USER"))
                .build();

        var token = jwtIssuer.issue(requestbuilder);

        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}

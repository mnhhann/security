package com.example.security.api;


import com.example.security.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

    @GetMapping("/")
    public String test(){
        return "helllll";
    }

    @GetMapping("/secured")
    public String getSecured(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return "if you see this, then you are login" + userPrincipal.getUsername();
    }
}

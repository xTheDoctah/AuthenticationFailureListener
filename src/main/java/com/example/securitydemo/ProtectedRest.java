package com.example.securitydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectedRest {

    @GetMapping("/protected")
    public void protectedSer() {
        System.out.println("Hola!");
    }
}

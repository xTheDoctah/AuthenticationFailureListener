package com.example.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationFailureListener
        implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private final HttpServletRequest request;

    public AuthenticationFailureListener(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        System.out.println(event.getAuthentication());
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
           //loginAttemptService.loginFailed(request.getRemoteAddr());
            System.out.println("HEADER NULL");
        } else {
           // loginAttemptService.loginFailed(xfHeader.split(",")[0]);
            System.out.println("HEADER NOT NULL");
        }
    }
}
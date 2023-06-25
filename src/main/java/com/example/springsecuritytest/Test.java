package com.example.springsecuritytest;

import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.Serializable;

public class Test {

    private void test(){
        BasicAuthenticationFilter basicAuthenticationFilter;
        SecurityFilterChain securityFilterChain;
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
        Serializable serializable;
        FirebaseAuthException firebaseAuthException;
        AuthenticationManagerBuilder authenticationManagerBuilder;
        AuthenticationProvider authenticationProvider;
        AuthenticationManager authenticationManager;
    }
}

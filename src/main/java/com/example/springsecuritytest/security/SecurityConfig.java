//package com.example.springsecuritytest.security;
//
//import com.google.firebase.auth.FirebaseAuth;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
//
//
//
//    private final FirebaseAuth firebaseAuth;
//
//    public SecurityConfig( FirebaseAuth firebaseAuth) {
//
//        this.firebaseAuth = firebaseAuth;
//    }
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        FirebaseAuthenticationFilter firebaseAuthenticationFilter =
//                new FirebaseAuthenticationFilter("/start/**",
//                         firebaseAuth);
//        return http
////                .csrf().disable()
//                .addFilterBefore(firebaseAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .build();
//    }
//
////    @Bean
////    public AuthenticationManager authenticationManagerBean() throws Exception {
////        return authentication -> {
////            // Customize authentication if needed
////        };
////    }
//}
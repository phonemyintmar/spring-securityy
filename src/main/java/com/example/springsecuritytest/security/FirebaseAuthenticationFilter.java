//package com.example.springsecuritytest.security;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthException;
//import com.google.firebase.auth.FirebaseToken;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.security.Principal;
//
//public class FirebaseAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//    private final FirebaseAuth firebaseAuth;
//
//    public FirebaseAuthenticationFilter(String defaultFilterProcessesUrl, FirebaseAuth firebaseAuth) {
//        super("/login",null);
//
//        this.firebaseAuth = firebaseAuth;
////        Principal
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        System.out.println("d ko yout");
//        String token = extractToken(request); // Extract the token from the request headers or query parameters
//        if (token == null) throw new AuthenticationServiceException("No Auth in the request");
//        try {
//            // or use a custom identifier from the token
//            return getAuthenticationManager().authenticate(new FirebaseAuthenticationToken("custom", token));
//        } catch (Exception e) {
//            throw new AuthenticationServiceException("Failed to authenticate with Firebase", e);
//        }
//    }
//
//    private String extractToken(HttpServletRequest request) {
//        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (auth == null || auth.isBlank()) {
//            return null;
//        }
//        return auth.split(" ")[1];
//    }
//
//}
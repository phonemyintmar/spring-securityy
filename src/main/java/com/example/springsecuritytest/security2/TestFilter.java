package com.example.springsecuritytest.security2;

import com.google.firebase.auth.FirebaseAuth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class TestFilter extends OncePerRequestFilter {

    private final FirebaseAuth firebaseAuth;




    public TestFilter(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("test");
        FireAuthManager fireAuthManager = new FireAuthManager(firebaseAuth);
        Authentication authentication = fireAuthManager.authenticate(new FireAuthToken(extractToken(request)));
        if (authentication==null){
//            return;
            log.info("d m yout wo lr");
        }
        log.info("aa");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (auth == null || auth.isBlank()) {
            return null;
        }
        return auth.split(" ")[1];
    }
}

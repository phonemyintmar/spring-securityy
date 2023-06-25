package com.example.springsecuritytest.security2;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FireFilter extends AbstractAuthenticationProcessingFilter {

    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/login", "POST");

    public FireFilter(FireAuthManager fireAuthManager) {
        super("/ping");
        System.out.println("abcdefg");
        setAuthenticationManager(fireAuthManager);
    }

//    public FireFilter() {
//        super(DEFAULT_NAT_PATH_REQUEST_MATCHER);
//    }
//
//    public FireFilter(FireAuthManager fireAuthManager) {
//        super(DEFAULT_ANT_PATH_REQUEST_MATCHER, fireAuthManager);
//    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        logger.info("d ko youttt");
        String token = extractToken(request); // Extract the token from the request headers or query parameters
        if (token == null) {
            logger.error("no auth");
            return null;
        }
        try {
            this.setContinueChainBeforeSuccessfulAuthentication(true);
//            this.setSessionAuthenticationStrategy(null);
            return getAuthenticationManager().authenticate(new FireAuthToken(token));
        } catch (Exception e) {
            logger.error("Auth error");
            return null;
        }
    }

    private String extractToken(HttpServletRequest request) {
        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (auth == null || auth.isBlank()) {
            return null;
        }
        return auth.split(" ")[1];
    }
}

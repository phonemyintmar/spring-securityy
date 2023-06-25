package com.example.springsecuritytest.security2;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FireAuthManager implements AuthenticationManager {

    private final FirebaseAuth firebaseAuth;

    public FireAuthManager(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("ddd");
        String token = (String) authentication.getCredentials();
        try {
            log.info("token {}",token);
            log.info("fire auth vailid? ");
            FirebaseToken firebaseToken = firebaseAuth.verifyIdToken(token);
//            List<String> roles = getRoles(firebaseToken);
//            if (roles == null){
//                System.out.printf("abcd");
//                return null;
//            }
//            List<FirebaseRole> firebaseRoles = new ArrayList<>();
//            for (String role : roles) {
//                firebaseRoles.add(new FirebaseRole(role));
//            }
            log.info("d a hit yout tl ha");
            return new FireAuthToken(token, firebaseToken, null);
        } catch (FirebaseAuthException e) {
            log.info(e.getMessage());
            return null;
        }
    }

    private List<String> getRoles(FirebaseToken firebaseToken) {
        try {
            return (List<String>) firebaseToken.getClaims().get("role");
        } catch (Exception e) {
            return null;
        }
    }
}

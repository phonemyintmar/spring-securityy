//package com.example.springsecuritytest.security;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseToken;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//
//// WebSecurityConfigurerAdapter is depricated so we use filter instead of this way.
//@Component
//public class FirebaseAuthenticationManager implements AuthenticationManager {
//
//    private final FirebaseAuth firebaseAuth;
//
//    public FirebaseAuthenticationManager(FirebaseAuth firebaseAuth) {
//        this.firebaseAuth = firebaseAuth;
//    }
//
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String token = (String) authentication.getCredentials();
//
//        try {
//            FirebaseToken firebaseToken = firebaseAuth.verifyIdToken(token);
//            String username = firebaseToken.getEmail(); // or use a custom identifier from the token
//            return new FirebaseAuthenticationToken(username, token);
//        } catch (Exception e) {
//            throw new AuthenticationException("Invalid Firebase token") {};
//        }
//    }
//
////    @Override
////    public boolean supports(Class<?> authentication) {
////        return (FirebaseAuthenticationToken.class.isAssignableFrom(authentication));
////    }
//}

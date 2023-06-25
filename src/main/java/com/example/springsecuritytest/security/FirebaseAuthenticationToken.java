//package com.example.springsecuritytest.security;
//
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.util.Assert;
//
//import java.util.Collection;
//
//public class FirebaseAuthenticationToken extends AbstractAuthenticationToken {
//    private static final long serialVersionUID = 1000L;
//    private final Object principal;
//    private String firebaseToken;
//
//    public FirebaseAuthenticationToken(Object principal, String token) {
//        super(null);
//        this.principal = principal;
//        this.firebaseToken = token;
//        this.setAuthenticated(false);
//    }
//
//    public FirebaseAuthenticationToken(Object principal, String token, Collection<? extends GrantedAuthority> authorities) {
//        super(authorities);
//        this.principal = principal;
//        this.firebaseToken = token;
//        super.setAuthenticated(true);
//    }
//
//    public static UsernamePasswordAuthenticationToken unauthenticated(Object principal, Object credentials) {
//        return new UsernamePasswordAuthenticationToken(principal, credentials);
//    }
//
//    public static UsernamePasswordAuthenticationToken authenticated(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
//        return new UsernamePasswordAuthenticationToken(principal, credentials, authorities);
//    }
//
//    public String getCredentials() {
//        return this.firebaseToken;
//    }
//
//    public Object getPrincipal() {
//        return this.principal;
//    }
//
//    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
//        Assert.isTrue(!isAuthenticated, "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
//        super.setAuthenticated(false);
//    }
//
//    public void eraseCredentials() {
//        super.eraseCredentials();
//        this.firebaseToken = "";
//    }
//}

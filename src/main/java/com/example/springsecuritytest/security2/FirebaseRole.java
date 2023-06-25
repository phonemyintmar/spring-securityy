package com.example.springsecuritytest.security2;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
public class FirebaseRole implements GrantedAuthority {

    private String role;
    @Override
    public String getAuthority() {
        return role;
    }
}

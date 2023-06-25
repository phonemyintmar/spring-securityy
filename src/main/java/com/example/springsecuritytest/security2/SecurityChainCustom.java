package com.example.springsecuritytest.security2;

import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityChainCustom {

    private final FirebaseAuth firebaseAuth;

    public SecurityChainCustom(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.addFilterBefore(new FireFilter(new FireAuthManager(firebaseAuth)), UsernamePasswordAuthenticationFilter.class)
        httpSecurity.addFilterBefore(new TestFilter(firebaseAuth), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests()
//                .antMatchers("/").permitAll()
                .anyRequest().authenticated()   ;

        return httpSecurity.build();

    }
}

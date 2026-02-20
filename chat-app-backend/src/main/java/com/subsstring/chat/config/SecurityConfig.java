package com.subsstring.chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())   // disable csrf for websocket
                .cors(cors -> {})               // enable cors
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/chat/**").permitAll()  // allow websocket
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}

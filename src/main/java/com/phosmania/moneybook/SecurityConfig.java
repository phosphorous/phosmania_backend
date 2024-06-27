package com.phosmania.moneybook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/login").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginProcessingUrl("/api/login")
                                .defaultSuccessUrl("/api/welcome", true)
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/api/logout")
                                .logoutSuccessUrl("/api/login?logout")
                )
                .csrf(csrf -> csrf.disable());  // CSRF 보호 비활성화 (개발 목적)
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


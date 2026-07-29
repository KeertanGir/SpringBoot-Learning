package org.learnspringframework.jobboard.config;

import org.learnspringframework.jobboard.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    private final CustomUserService userService;

    public SecurityConfiguration(CustomUserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(token -> token.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.POST, "/jobboard/api/users").permitAll()   // signUp
                        .requestMatchers(HttpMethod.GET, "/jobboard/api/jobs/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/jobboard/api/companies/**").permitAll()
                        .requestMatchers(HttpMethod.GET,  "/jobboard/api/skills/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/jobboard/api/jobs").hasRole("RECRUITER")
                        .requestMatchers(HttpMethod.PUT, "/jobboard/api/jobs/**").hasRole("RECRUITER")
                        .requestMatchers(HttpMethod.DELETE, "/jobboard/api/jobs/**").hasRole("RECRUITER")
                        .requestMatchers(HttpMethod.POST, "/jobboard/api/applications").hasRole("CANDIDATE")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .authenticationProvider(daoAuthenticationProvider())
                .build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

}

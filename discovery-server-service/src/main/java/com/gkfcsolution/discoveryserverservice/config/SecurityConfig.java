package com.gkfcsolution.discoveryserverservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2025 at 21:55
 * File: null.java
 * Project: shoppingApplicationsMS
 *
 * @author Frank GUEKENG
 * @date 21/10/2025
 * @time 21:55
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

/*    @Value("${eureka.username}")
    private String username;
    @Value("${eureka.password}")
    private String password;*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public InMemoryUserDetailsManager configureAuthentication() {
        List<UserDetails> userDetails = new ArrayList<>();
//        List<GrantedAuthority> employeeRoles = new ArrayList<>();
        List<GrantedAuthority> adminRoles = new ArrayList<>();
        List<GrantedAuthority> userRoles = new ArrayList<>();
//        employeeRoles.add(new SimpleGrantedAuthority("EMPLOYEE"));
        adminRoles.add(new SimpleGrantedAuthority("ADMIN"));
        userRoles.add(new SimpleGrantedAuthority("USER"));

        userDetails.add(new User("eureka", "123456", userRoles));
//        userDetails.add(new User(username, password, userRoles));
//        userDetails.add(new User("admin", passwordEncoder().encode("123456"), adminRoles));
//        userDetails.add(new User("user", passwordEncoder().encode("123456"), userRoles));

        return new InMemoryUserDetailsManager(userDetails);
    }

  /*  @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/eureka/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

}

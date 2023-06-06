package com.example.buoi3_s2.config;

import com.example.buoi3_s2.Model.Product;
import com.example.buoi3_s2.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Repository;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailsService uds;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorize -> authorize
                        .requestMatchers("/home/**", "/login/**", "/logout/**").permitAll()
                        .requestMatchers("/products/**").hasAnyAuthority("USER", "SALES")
                        .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(withDefaults());
// .httpBasic(withDefaults())
//.authenticationProvider(authenticationProvider())

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService()
    {
        var userAdmin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities("ADMIN").build();
        var userSales = User.withUsername("sales")
                .password(passwordEncoder().encode("sales"))
                        .authorities("SALES").build();
        var user = User.withUsername("user")
                .password(passwordEncoder().encode("user"))
                        .authorities("USER").build();
        return new InMemoryUserDetailsManager(userAdmin, userSales, user);
    }
}

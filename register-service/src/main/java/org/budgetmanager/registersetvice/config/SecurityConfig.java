package org.budgetmanager.registersetvice.config;

import org.budgetmanager.registersetvice.filter.JwtAuthFilter;
import org.springframework.beans.factory.ObjectProvider; // Import ObjectProvider
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Use ObjectProvider to lazily get JwtAuthFilter when it's actually needed
    // This breaks the direct dependency during SecurityConfig's initial creation.
    private final ObjectProvider<JwtAuthFilter> jwtAuthFilterProvider;

    // Keep @Lazy for UserDetailsService to handle the UserInfoService -> SecurityConfig -> UserInfoService cycle
    private final UserDetailsService userDetailsService;

    // Constructor now takes ObjectProvider for JwtAuthFilter and @Lazy UserDetailsService
    public SecurityConfig(ObjectProvider<JwtAuthFilter> jwtAuthFilterProvider, @Lazy UserDetailsService userDetailsService) {
        this.jwtAuthFilterProvider = jwtAuthFilterProvider;
        this.userDetailsService = userDetailsService;
    }

    @Bean // New, temporary securityFilterChain
    public SecurityFilterChain tempSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Still disable CSRF for API
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // PERMIT ALL REQUESTS
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password hashing
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // The userDetailsService here will be the lazy-loaded proxy, resolving UserInfoService.
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder()); // PasswordEncoder is available from this config.
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager(); // Expose AuthenticationManager
    }
}

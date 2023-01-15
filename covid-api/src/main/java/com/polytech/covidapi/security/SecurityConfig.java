package com.polytech.covidapi.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    LoginFailureHandler failureHandler;
    @Autowired
    LoginSuccessHandler successHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable();
        http
                .formLogin()
                .loginProcessingUrl("http://127.0.0.1:3000/login")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and()
                .authorizeHttpRequests((authz) -> authz
                        .mvcMatchers("/public").permitAll()
                        .mvcMatchers("/admin").authenticated()
                        .antMatchers("/login").permitAll()
                )
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

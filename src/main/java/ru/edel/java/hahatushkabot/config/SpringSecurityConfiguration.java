package ru.edel.java.hahatushkabot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/jokes").permitAll() // Доступ для всех к методам GET
                .antMatchers("/jokes/{id}").permitAll() // Доступ для всех к методам GET
                .antMatchers(HttpMethod.POST, "/jokes").hasAuthority("USER") // Доступ только для пользователей с ролью "USER"
                .antMatchers(HttpMethod.PUT, "/jokes/{id}").hasAuthority("MODERATOR") // Доступ только для пользователей с ролью "MODERATOR"
                .antMatchers(HttpMethod.DELETE, "/jokes/{id}").hasAuthority("MODERATOR") // Доступ только для пользователей с ролью "MODERATOR"
                .antMatchers("/users/**").hasAuthority("ADMIN") // Доступ только для пользователей с ролью "ADMIN"
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();
    }
}

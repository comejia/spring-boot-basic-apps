package com.spring.error;

import com.spring.error.models.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Pepe", "Gonzalez"));
        users.add(new User(2L, "Andres", "Gonzalez"));
        users.add(new User(3L, "Maria", "Gonzalez"));
        users.add(new User(4L, "Josefa", "Gonzalez"));

        return users;
    }
}

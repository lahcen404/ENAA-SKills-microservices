package com.enaa_skill.user_service.services;

import com.enaa_skill.user_service.dto.RegistrationRequest;
import com.enaa_skill.user_service.model.Learner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class UserServiceTest {
    @Autowired
     UserService userService ;

    @Test
    void registerLearner() {
        RegistrationRequest user = new RegistrationRequest();
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setPassword("password123");

        Learner savedLearner = userService.registerLearner(user);

        assertThat(savedLearner).isNotNull();
        assertThat(savedLearner.getUsername()).isEqualTo("testuser");
        assertThat(savedLearner.getEmail()).isEqualTo("test@example.com");
    }

}
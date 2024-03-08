package com.example.cloud_tracker.repository;

import com.example.cloud_tracker.model.User;
import init.UserInit;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindUserByEmail() {
        User user = UserInit.createUser();
        userRepository.save(user);

        Optional<User> found = userRepository.findByEmail(user.getEmail());

        Assertions.assertThat(found).isPresent();
        Assertions.assertThat(found.get().getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserById() {
        User user = UserInit.createUser();
        userRepository.save(user);

        Optional<User> found = userRepository.findById(user.getId());

        Assertions.assertThat(found).isPresent();
        Assertions.assertThat(found.get().getId()).isEqualTo(user.getId());
    }

}

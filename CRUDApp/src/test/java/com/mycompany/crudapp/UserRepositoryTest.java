package com.mycompany.crudapp;

import com.mycompany.crudapp.dao.UserRepository;
import com.mycompany.crudapp.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired private UserRepository repository;

    @Test
    public void testAddNew(){
        User user=new User();
        user.setEmail("abc@gmail.com");
        user.setPassword("12345678");
        user.setFirstName("Nick");
        user.setLastName("Jonas");

        User savedUser=repository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> users= repository.findAll();
       Assertions.assertThat(users).hasSizeGreaterThan(0);
       users.forEach(user -> System.out.println(user));
    }

    @Test
    public void testUpdate(){
        Integer userId=1;
        Optional<User> optional=repository.findById(userId);
        User user= optional.get();
        user.setPassword("87654321");
        repository.save(user);

        User updatedUser=repository.findById(userId).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("87654321");
    }
    @Test
    public void testGet(){
        Integer userId=1;
        Optional<User> optional= repository.findById(userId);
        Assertions.assertThat(optional).isPresent();
        System.out.println(optional.get());
    }

    @Test
    public void testDelete(){
        Integer userID=1;
        repository.deleteById(userID);
        Optional<User> optional=repository.findById(userID);
        Assertions.assertThat(optional).isNotPresent();
    }
}


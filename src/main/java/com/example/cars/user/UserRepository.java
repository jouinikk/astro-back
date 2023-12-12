package com.example.cars.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
    @Override
    Optional<User> findById(Integer integer);

    List<User> findUsersByFirstNameAndLastName(String first, String last);


    List<User> findUsersByFirstName(String first);
}


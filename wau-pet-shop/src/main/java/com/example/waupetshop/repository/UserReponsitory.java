package com.example.waupetshop.repository;

import com.example.waupetshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserReponsitory extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "select * " +
            "from users u " +
            "where u.email like (:email);")
    User findByEmail(String email);
}

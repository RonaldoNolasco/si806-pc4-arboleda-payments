package com.arboleda.arboledapayments.repository;

import com.arboleda.arboledapayments.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

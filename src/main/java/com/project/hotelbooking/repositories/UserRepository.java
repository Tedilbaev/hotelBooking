package com.project.hotelbooking.repositories;

import com.project.hotelbooking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}

package com.ashwani.redisspring.infra.repository;

import com.ashwani.redisspring.infra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

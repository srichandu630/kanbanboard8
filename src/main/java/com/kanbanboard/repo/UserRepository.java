package com.kanbanboard.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kanbanboard.entity.User;


@Repository 
public interface UserRepository extends JpaRepository<User, Integer>{

	User save(User user);

	Optional<User> findByUserId(Integer userId);

}
package com.github.gif26.izzy_financs.repository;

import com.github.gif26.izzy_financs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

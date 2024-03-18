package com.Springopro.Springpro.Repository;

import com.Springopro.Springpro.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}

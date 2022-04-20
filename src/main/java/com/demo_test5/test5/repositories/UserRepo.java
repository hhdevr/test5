package com.demo_test5.test5.repositories;

import com.demo_test5.test5.entitys.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}

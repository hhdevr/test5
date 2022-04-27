package com.demo_test5.test5.repositories;

import com.demo_test5.test5.entitys.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}

package com.company.junit.stub.repositories;

import com.company.junit.stub.repositories.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

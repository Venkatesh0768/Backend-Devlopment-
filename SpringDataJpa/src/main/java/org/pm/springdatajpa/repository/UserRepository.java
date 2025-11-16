package org.pm.springdatajpa.repository;

import org.pm.springdatajpa.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User , Integer> {
    List<User> findUserById(Integer id);
}

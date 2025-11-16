package org.pm.springdatajpa.service;

import org.pm.springdatajpa.model.User;

import java.util.Optional;

public interface UserService {
//    String registerUser(User user);
//     Iterable<User> registerMultipleUser(Iterable<User> users);
//     User findUser(Integer id);

    Optional<User> searchUserById(Integer id);

}

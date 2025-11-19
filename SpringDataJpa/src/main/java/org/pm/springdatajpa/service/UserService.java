package org.pm.springdatajpa.service;

import org.pm.springdatajpa.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
//    String registerUser(User user);
//     Iterable<User> registerMultipleUser(Iterable<User> users);
//     User findUser(Integer id);

    public String registerUser(User user);
    Optional<User> searchUserById(Integer id);
    List<User> searchByName(String name);
    public int updateThePriceBasedOnTHeName(int newCost , String userName);

}

package org.pm.springdatajpa.service;

import org.pm.springdatajpa.model.User;
import org.pm.springdatajpa.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String registerUser(User user) {
        userRepository.save(user);
        return "User Registered Successfully";
    }

    @Override
    public Iterable<User> registerMultipleUser(Iterable<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public User findUser(Integer id) {
        return (User) userRepository.findUserById(id);
    }
}










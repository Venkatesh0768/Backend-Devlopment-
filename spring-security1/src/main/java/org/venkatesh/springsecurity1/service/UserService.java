package org.venkatesh.springsecurity1.service;

import org.springframework.stereotype.Service;
import org.venkatesh.springsecurity1.model.User;
import org.venkatesh.springsecurity1.repo.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}

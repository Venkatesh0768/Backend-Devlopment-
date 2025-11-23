package org.venkatesh.springsecurity1.service;

import org.venkatesh.springsecurity1.model.User;

import java.util.List;

public interface IUserService {
    User register (User user);
    List<User> getAllUser();
}

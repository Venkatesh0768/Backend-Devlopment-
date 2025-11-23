package org.venkatesh.springsecurity1.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.venkatesh.springsecurity1.model.User;
import org.venkatesh.springsecurity1.repo.UserRepository;


import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository repository;

    public MyUserDetailService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        return new UserDetailsPrincipal(user);
    }
}

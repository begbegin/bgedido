package com.gbedido.gbedido.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gbedido.gbedido.repository.UserRepository;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	com.gbedido.gbedido.domain.User User = userRepository.findByLogin(username);
        if (User == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(User.getLogin(), User.getPassword(), emptyList());
    }
}
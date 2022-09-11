package com.example.demo.services;
import com.example.demo.models.UserSecurity;
import com.example.demo.models.Users;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserSecurityServies implements UserDetailsService {


    final UserRepository userRepository;
    @Autowired
    public UserSecurityServies(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users =  userRepository.findByName(username);

        return new UserSecurity(users);
    }
}

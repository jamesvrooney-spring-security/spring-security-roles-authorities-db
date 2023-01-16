package com.jamesvrooney.services;

import com.jamesvrooney.models.SecurityUser;
import com.jamesvrooney.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        return user;
    }
}

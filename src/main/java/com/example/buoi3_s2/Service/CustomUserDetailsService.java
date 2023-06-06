package com.example.buoi3_s2.Service;

import com.example.buoi3_s2.Model.User;
import com.example.buoi3_s2.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements
        UserDetailsService {
    @Autowired
    private userRepository u;
//   @Override
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//        String pass;
//        Set<GrantedAuthority> authorities = new HashSet<>();
//        if(username == "admin") {
//            pass = "admin";
//            authorities.add(new SimpleGrantedAuthority("ADMIN"));
//        }
//        else if(username == "sales") {
//            pass = "sales";
//            authorities.add(new SimpleGrantedAuthority("SALES"));
//        }
//        else {
//            pass ="user";
//            authorities.add(new SimpleGrantedAuthority("USER"));
//        }
//        return new org.springframework.security.core.userdetails.User(
//                username,
//                new BCryptPasswordEncoder().encode(pass),
//                authorities
//        );
//    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException
    {

        User u = userRepository.getUserByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        Set<GrantedAuthority> authorities = u.getRoles().stream()
                .map((role) -> new

                        SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        return new
                org.springframework.security.core.userdetails.User(

                username,
                u.getPassword(),
                authorities
        );
    }
}
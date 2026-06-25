package com.aarthi.careerassistant.service;

import com.aarthi.careerassistant.dto.LoginRequest;
import com.aarthi.careerassistant.dto.UserRequest;
import com.aarthi.careerassistant.entity.User;
import com.aarthi.careerassistant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(UserRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(
        	    passwordEncoder.encode(
        	        request.getPassword()
        	    )
        	);

        return userRepository.save(user);
    }
    
    public String loginUser(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElse(null);

        if(user == null) {
            return "User Not Found";
        }
        if(passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            return "Login Successful";
        }



        return "Invalid Password";
    }
    
}
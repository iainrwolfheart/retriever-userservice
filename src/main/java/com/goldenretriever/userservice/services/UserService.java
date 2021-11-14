package com.goldenretriever.userservice.services;

import com.goldenretriever.userservice.entities.User;
import com.goldenretriever.userservice.entities.requests.UpdatePasswordRequest;
import com.goldenretriever.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService<T extends User> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> saveNewUser(T user) {

//        Check user !exists!!
        if (!userRepository.userExists(user.getUsername(), user.getEmail())) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("New user successfully created.");
        } else {
//            Doesn't tell you whether conflict was with email or username...
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }

    }

    public ResponseEntity<String> updatePassword(UpdatePasswordRequest pwReq) {

        try {
            User user;
            user = userRepository.findByEmail(pwReq.getEmail());

            if (!passwordEncoder.matches(pwReq.getOldPassword(), user.getPassword())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Old password does not match database entry.");
            }

            user.setPassword(pwReq.getNewPassword());
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body("Password updated successfully.");

        } catch (NullPointerException npe) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email doesn't exist.");
        }
    }
}

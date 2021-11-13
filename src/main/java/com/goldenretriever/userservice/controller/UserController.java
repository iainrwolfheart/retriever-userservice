package com.goldenretriever.userservice.controller;

import com.goldenretriever.userservice.entities.User;
import com.goldenretriever.userservice.entities.requests.UpdatePasswordRequest;
import com.goldenretriever.userservice.repositories.UserRepository;
import com.goldenretriever.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController<T extends User> {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

//    POST createUser
    @PostMapping("/create")
    public T createUser(@RequestBody T user) {
        return (T) userService.saveNewUser(user);
    }

//    UPDATE user

//    CHANGE PASSWORD
    @PutMapping("/update/password")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequest pwReq) {
//        Remove email from UpdatePasswordRequest class once Spring Security in place
        return userService.updatePassword(pwReq);
    }
//    GET user by id
    @GetMapping("/")
    public String get() {
        return "Hi";
    }
//    DELETE user
    @DeleteMapping("/deleteuser/{userId}")
    public void deleteUser(@PathVariable("userId") String _userId) {
//        userService.removeUser(_userId);
        userRepository.deleteBy_UserId(_userId);
    }
}

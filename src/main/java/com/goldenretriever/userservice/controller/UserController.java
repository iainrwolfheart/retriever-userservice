package com.goldenretriever.userservice.controller;

import com.goldenretriever.userservice.entities.Artist;
import com.goldenretriever.userservice.entities.Retriever;
import com.goldenretriever.userservice.entities.User;
import com.goldenretriever.userservice.entities.requests.UpdatePasswordRequest;
import com.goldenretriever.userservice.repositories.UserRepository;
import com.goldenretriever.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController<T extends User> {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    //    POST createUser
    @PostMapping("/create/retriever")
    public ResponseEntity<String> createRetriever(@RequestBody Retriever retriever) {
        return userService.saveNewUser(retriever);
    }
//    Create a DTO Mapper method to handle the overloading..?
    @PostMapping("/create/artist")
    public ResponseEntity<String> createRetriever(@RequestBody Artist artist) {
        return userService.saveNewUser(artist);
    }

//    UPDATE user

//    CHANGE PASSWORD
    @PutMapping("/update/password")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequest pwReq) {
//        Remove email from UpdatePasswordRequest class once Spring Security in place
        return userService.updatePassword(pwReq);
    }
//    GET user by id
//    @GetMapping("/{_userId}")
//    public String getById(@PathVariable("_userId") String _userId) {
//        return userRepository.findBy_userId(_userId).toString();
//    }

    /*
    Need to move _userId out of exposed path variable
     */
    @DeleteMapping("/delete/{_userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("_userId") String _userId) {
        userRepository.deleteById(_userId);
        return ResponseEntity.status(HttpStatus.OK).body("User has been deleted.");
    }
}

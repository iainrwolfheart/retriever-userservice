package com.goldenretriever.userservice.services;

import com.goldenretriever.userservice.entities.Artist;
import com.goldenretriever.userservice.entities.Retriever;
import com.goldenretriever.userservice.repositories.UserRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

class UserServiceTest {

    private UserService userService;
    @MockBean
    UserRepository userRepository;
    @MockBean
    PasswordEncoder encoder;
    Artist testArtist;
    Retriever testRetriever;
    Mockito mockito;

    @BeforeEach
    void setup() {
        this.testArtist = new Artist("artistUname", "artist@test.com",
                "artistP@55w0rd", "Artist Name", "C389687386DG_90");
        this.testRetriever = new Retriever("retrieverUname", "retriever@test.com",
                "retrieverP@55w0rd");
    }

    @Test
    @DisplayName("Save new user happy path")
    void saveNewUserHappyPath() {

    }

    @Ignore
    @Test
    @DisplayName("Test wrong password prevents update.")
    void updatePasswordWithMismatchedUserPassword() {

    }

    @Ignore
    @Test
    @DisplayName("Update password happy path")
    void updatePassword() {

    }
}
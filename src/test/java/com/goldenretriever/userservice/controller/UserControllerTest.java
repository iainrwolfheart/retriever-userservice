package com.goldenretriever.userservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldenretriever.userservice.entities.Artist;
import com.goldenretriever.userservice.entities.Retriever;
import com.goldenretriever.userservice.repositories.UserRepository;
import com.goldenretriever.userservice.services.UserService;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    private UserController userController;
    @MockBean
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    Artist testArtist;
    Retriever testRetriever;

    public UserControllerTest() {
        userController = new UserController(userService, userRepository);
    }

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
        this.testArtist = new Artist("artistUname", "artist@test.com",
                "artistP@55w0rd", "Artist Name", "C389687386DG_90");
        this.testRetriever = new Retriever("retrieverUname", "retriever@test.com",
                "retrieverP@55w0rd");
    }

    //    Test parameter of type artist
    @Test
    @DisplayName("Create Artist happy path")
    void testCreateArtistHappyPath() throws Exception {

        RequestBuilder req = post("/create/artist", this.testArtist)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult res = this.mockMvc.perform(req)
                .andReturn();
        System.out.println(res.getResponse().toString());

        mockMvc.perform(post("/create/artist", this.testArtist)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testArtist)))
                .andExpect(status().isCreated());
    }
    //    Test parameter of type retriever
//    Test successful status and body for create
//    Test conflict status in creating


    @Test
    @Ignore
    void testCreateRetriever() {
    }

    @Test
    @Ignore
    void updatePassword() {
    }

    @Test
    @Ignore
    void deleteUser() {
    }
}
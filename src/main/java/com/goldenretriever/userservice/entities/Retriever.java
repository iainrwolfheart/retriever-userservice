package com.goldenretriever.userservice.entities;

import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@TypeAlias("retriever")
@Data
public class Retriever extends User {
    public Retriever(String username, String email, String password) {
        super(username, email, password);
    }
}

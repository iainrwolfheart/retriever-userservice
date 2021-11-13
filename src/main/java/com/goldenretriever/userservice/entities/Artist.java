package com.goldenretriever.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@TypeAlias("artist")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Artist extends User {

    private String artistName;
    private String _caseId;
}

package com.goldenretriever.userservice.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.json.JSONObject;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@TypeAlias("artist")
@EqualsAndHashCode(callSuper = true)
@Data
public class Artist extends User {

    private String artistName;
    private String _caseId;

    public Artist(String username, String email, String password,
                  String artistName, String _caseId) {
        super(username, email, password);
        this.artistName = artistName;
        this._caseId = _caseId;
    }

    @Override
    public String toString() {
        JSONObject artistDto = new JSONObject();
        try {
            artistDto.put("username", super.getUsername());
            artistDto.put("artistName", this.artistName);
            artistDto.put("_caseId", this._caseId);
        } catch (NullPointerException npe) {
            return npe.getMessage();
        }

        return artistDto.toString();
    }
}

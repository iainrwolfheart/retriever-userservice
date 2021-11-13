package com.goldenretriever.userservice.entities.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class UpdatePasswordRequest {

    private String email;
    private String oldPassword;
    private String newPassword;
}

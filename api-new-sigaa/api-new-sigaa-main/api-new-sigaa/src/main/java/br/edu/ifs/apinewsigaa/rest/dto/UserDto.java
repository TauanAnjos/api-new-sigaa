package br.edu.ifs.apinewsigaa.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private boolean emailVerified;
    private List<CredentialDto> credentials;
}

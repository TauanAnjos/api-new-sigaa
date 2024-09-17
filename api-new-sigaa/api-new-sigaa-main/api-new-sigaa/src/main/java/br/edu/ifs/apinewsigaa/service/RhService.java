package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.rest.dto.UserDto;
import br.edu.ifs.apinewsigaa.webservice.client.keycloak.KeycloakServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RhService {
    @Autowired
    private KeycloakServiceClient keycloakServiceClient;
    public void createUser(String token, UserDto userDto){

        keycloakServiceClient.creatUser(token, userDto);
    }

}

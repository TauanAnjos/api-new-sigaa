package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.rest.dto.UserDto;
import br.edu.ifs.apinewsigaa.webservice.client.keycloak.KeycloakServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RhService {
    @Autowired
    private KeycloakServiceClient keycloakServiceClient;

    //A classe que estou instanciando é a classe do serviço que vou consumir.
    public void createUser(String token, UserDto userDto){
        //estou requisitando o serviço da classe keycloakServiceClient
        keycloakServiceClient.creatUser(token, userDto);
    }

}

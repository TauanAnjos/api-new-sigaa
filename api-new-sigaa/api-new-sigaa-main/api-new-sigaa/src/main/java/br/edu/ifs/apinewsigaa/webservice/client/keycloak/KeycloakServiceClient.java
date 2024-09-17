package br.edu.ifs.apinewsigaa.webservice.client.keycloak;

import br.edu.ifs.apinewsigaa.rest.dto.UserDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KeycloakServiceClient {
    private final String keycloakCreateUser = "http://localhost:8081/admin/realms/teste/users";

    public void creatUser(String token, UserDto userDto){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<UserDto> request = new HttpEntity<>(userDto, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(keycloakCreateUser,request, String.class);

//        if (response.getStatusCode().is2xxSuccessful()) {
//            System.out.println("Usuário criado com sucesso");
//        } else {
//            throw new RuntimeException("Falha ao criar usuário: " + response.getStatusCode());
//        }

    }
}

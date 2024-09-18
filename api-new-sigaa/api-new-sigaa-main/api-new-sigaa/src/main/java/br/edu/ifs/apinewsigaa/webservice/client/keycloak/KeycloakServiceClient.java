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
    //URL de consumo para criação de usuário
    private final String keycloakCreateUser = "http://localhost:8081/admin/realms/teste/users";

    //metodo que requisita a criação de usuário
    public void creatUser(String token, UserDto userDto){


        //Estou criando uma variável para fazer uma requisição(RestTemplate é uma classe que faz requisições HTTP)
        RestTemplate restTemplate = new RestTemplate();

        //criando um objeto para armazena o cabeçalho da requisição
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        //setando o formato da requisição, que o tipo de conteudo vai ser json
        headers.setContentType(MediaType.APPLICATION_JSON);
        //Estou setando qual cabeçalho vou usar, no caso Authorization, tipo bearer token, e passo a variável token.
        headers.set("Authorization", "Bearer " + token);
        // configurações do request, oque o keycloak espera
        HttpEntity<UserDto> request = new HttpEntity<>(userDto, headers);
        //Solicitando crianção de usuário no keycloak, enviando URL, a request(configuração corpo de usuário e cabeçalho, e classe q esperamos como retorno.
        ResponseEntity<String> response = restTemplate.postForEntity(keycloakCreateUser,request, String.class);

    }
}

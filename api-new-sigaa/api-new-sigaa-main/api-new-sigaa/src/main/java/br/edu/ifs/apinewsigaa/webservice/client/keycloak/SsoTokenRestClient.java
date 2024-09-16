package br.edu.ifs.apinewsigaa.webservice.client.keycloak;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class SsoTokenRestClient {

    public String getServicePath(){
        return "http://localhost:8081/realms/teste/protocol/openid-connect/token";
    }
    public String gerarTokenSso(){
        /*String retorno = null;
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");*/

        String body = "grant_type=" + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8) + "&" +
                "client_id=" + URLEncoder.encode("api-backend", StandardCharsets.UTF_8) + "&" +
                "client_secret=" + URLEncoder.encode("n5BEyhCs2mDWsTVk6vQfNsZQgmWCqWEx", StandardCharsets.UTF_8);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getServicePath()))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            ObjectMapper objectMapper = new ObjectMapper();
            TokenSsoResponse myObject = objectMapper.readValue(response.body(), TokenSsoResponse.class);
            System.out.println("Response: " + myObject.getAccessToken());

        }catch (Exception e){

        }




        return null;
    }
}

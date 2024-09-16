package br.edu.ifs.apinewsigaa.webservice.client.keycloak;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TokenSsoResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private int expiresIn;
    @JsonProperty("refresh_expires_in")
    private int refreshExpiresIn;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("not-before-policy")
    private int notBeforePolicy;
    private String scope;

}

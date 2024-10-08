package br.edu.ifs.apinewsigaa;

//import br.edu.ifs.apinewsigaa.webservice.client.keycloak.SsoTokenRestClient;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * Define o esquema de segurança para integração com o Keycloak.
 * O esquema é configurado como OPENIDCONNECT com tipo de autenticação "bearer".
 * A URL de conexão é fornecida para o endpoint OpenID Connect do Keycloak.
 * Os tokens de autenticação são passados no cabeçalho da solicitação (HEADER).
 */
@SecurityScheme(
		name = "Keycloak"
		, openIdConnectUrl = "http://localhost:8081/realms/teste/.well-known/openid-configuration"
		, scheme = "bearer"
		, type = SecuritySchemeType.OPENIDCONNECT
		, in = SecuritySchemeIn.HEADER
)
public class ApiNewSigaaApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiNewSigaaApplication.class, args);

	}
}

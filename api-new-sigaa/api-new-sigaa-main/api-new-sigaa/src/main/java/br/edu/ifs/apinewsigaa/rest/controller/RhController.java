package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.rest.dto.UserDto;
import br.edu.ifs.apinewsigaa.service.RhService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "Keycloak")
public class RhController {

    @Autowired
    private RhService rhService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestHeader("Authorization") String token, @RequestBody UserDto userDTO) {
        try {
            rhService.createUser(token.substring(7), userDTO);
            return ResponseEntity.ok("Usuario criado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar usuario " + e.getMessage());
        }
    }
}

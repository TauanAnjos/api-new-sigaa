package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.model.TurmaModel;
import br.edu.ifs.apinewsigaa.rest.dto.TurmaDto;
import br.edu.ifs.apinewsigaa.service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
@SecurityRequirement(name = "Keycloak")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @Operation(
            summary = "Salvar turma",
            description = "Salvar turma no banco de dados",
            tags = "Turma"
    )
    @PostMapping
    public ResponseEntity<TurmaDto> salvarTurma(@RequestBody @Valid TurmaModel turmaModel){
        TurmaDto turmaDto = turmaService.salvarTurma(turmaModel);
        return ResponseEntity.ok(turmaDto);
    }
    @Operation(
            summary = "Buscar turma",
            description = "Buscar turmapor id, no banco de dados",
            tags = "Turma"
    )
    @GetMapping("/{id}")
    public ResponseEntity<TurmaDto> buscarPorId(@PathVariable("id") int id){
        TurmaDto turmaDto = turmaService.buscarTurmaPorId(id);
        return ResponseEntity.ok(turmaDto);
    }
    @Operation(
            summary = "Buscar turmas",
            description = "Buscar todas turmas no banco de dados",
            tags = "Turma"
    )
    @GetMapping
    public ResponseEntity<List<TurmaDto>> findaAll(){
        List<TurmaDto> list = turmaService.buscarTurmas();
        return ResponseEntity.ok(list);
    }
    @Operation(
            summary = "Deletar turma",
            description = "Deletar turma por id, no banco de dados",
            tags = "Turma"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTurma(@PathVariable("id") int id){
        turmaService.deleteTurma(id);
        return ResponseEntity.ok("Turma deletada com sucesso!");
    }
}

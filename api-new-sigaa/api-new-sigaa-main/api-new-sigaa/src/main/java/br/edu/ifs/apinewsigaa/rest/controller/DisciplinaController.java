package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaDto;
import br.edu.ifs.apinewsigaa.service.DisciplinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplina")
@SecurityRequirement(name = "Keycloak")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @Operation(
            summary = "Salvar disciplina",
            description = "Salva disciplina no banco de dados",
            tags = "Disciplina"
    )
    @PostMapping
    public ResponseEntity<DisciplinaDto> salvarDisciplina(@RequestBody DisciplinaDto disciplina){
        DisciplinaDto disciplinaDto = disciplinaService.salvarDisciplina(disciplina);
        return ResponseEntity.ok(disciplinaDto);
    }
    @Operation(
            summary = "Buscar disciplinas",
            description = "Busca todas as disciplinas no banco de dados",
            tags = "Disciplina"
    )
    @GetMapping
    public ResponseEntity<List<DisciplinaDto>> todasDisciplinas(){
        List<DisciplinaDto> list = disciplinaService.TodasDisciplinas();
        return ResponseEntity.ok(list);
    }
    @Operation(
            summary = "Busca disciplina",
            description = "Busca disciplina pelo nome, no banco de dados ",
            tags = "Disciplina"
    )

    @GetMapping("/{nomeDisciplina}")
    public ResponseEntity<DisciplinaDto> buscarDisciplinaNome(@PathVariable("nomeDisciplina") String nome){
        DisciplinaDto disciplinaDto = disciplinaService.BuscarDisciplinaPorNome(nome);
        return ResponseEntity.ok(disciplinaDto);
    }

    @Operation(
            summary = "Deletar disciplina",
            description = "Deletar disciplina no banco de dados",
            tags = "Disciplina"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDisciplina(@PathVariable("id") int id){
        disciplinaService.deleteDisciplinaPorId(id);
        return ResponseEntity.ok("Disciplina deletada com sucesso!");
    }

    @Operation(
            summary = "Atualiza disciplina",
            description = "Atualiza disciplina existente no banco de dados",
            tags = "Disciplina"
    )
    @PutMapping
    public ResponseEntity<DisciplinaDto> atualizarDisciplina(@RequestBody @Valid DisciplinaModel disciplina){
        disciplinaService.atualizarDisciplina(disciplina);
        return ResponseEntity.ok(disciplina.toDto());
    }
}

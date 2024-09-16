package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.rest.dto.ProfessorDto;
import br.edu.ifs.apinewsigaa.service.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
@SecurityRequirement(name = "Keycloak")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Operation(
            summary = "Salvar professor",
            description = "Salva professor no banco de dados",
            tags = "Professor"
    )
    @PostMapping
    public ResponseEntity<ProfessorDto> salvarProfessor(@RequestBody ProfessorDto professorDto){
        professorService.salvarProfessor(professorDto.toModel());
        return ResponseEntity.ok(professorDto);
    }

    @Operation(
            summary = "Buscar professores",
            description = "Buscar todos os professores no banco de dados",
            tags = "Professor"
    )
    @GetMapping
    public ResponseEntity<List<ProfessorDto>> todosProfessores(){
        List<ProfessorDto> list = professorService.todosProfessores();
        return ResponseEntity.ok(list);
    }

    @Operation(
            summary = "Buscar professor",
            description = "Salva professor por matrícula, no banco de dados",
            tags = "Professor"
    )
    @GetMapping("/{matricula}")
    public ResponseEntity<ProfessorDto> BuscarProfessorPorMatricula(@PathVariable("matricula") String matricula){
        ProfessorDto professorDto = professorService.buscarPorMatricula(matricula);
        return ResponseEntity.ok(professorDto);
    }

    @Operation(
            summary = "Deletar professor",
            description = "Deletar professor através da matrícula, no banco de dados",
            tags = "Professor"
    )
    @DeleteMapping("/matricula/{matricula}")
    public ResponseEntity<String> deletePorMatricula(@PathVariable("matricula") String matricula){
        professorService.deletePorMatricula(matricula);
        return ResponseEntity.ok("Matricula deletada com sucesso!");
    }
    @Operation(
            summary = "Deletar professor",
            description = "Deletar professor através do ID, no banco de dados",
            tags = "Professor"
    )
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id")int id){
        professorService.deleteById(id);
        return ResponseEntity.ok("ID deletado com sucesso!");
    }

    @Operation(
            summary = "Atualizar professor",
            description = "Atualizar professor por matrícula, no banco de dados",
            tags = "Professor"
    )
    @PutMapping("/{matricula}")
    public ResponseEntity<ProfessorDto> atualizarProfessor(@PathVariable("matricula")String matricula, @RequestBody @Valid ProfessorDto professorExistente){
        professorService.atualizarProfessor(matricula, professorExistente.toModel());
        return ResponseEntity.ok(professorExistente);
    }

}

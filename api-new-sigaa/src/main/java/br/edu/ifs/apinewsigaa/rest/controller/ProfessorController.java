package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.rest.dto.ProfessorDto;
import br.edu.ifs.apinewsigaa.service.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> todosProfessores(){
        List<ProfessorDto> list = professorService.todosProfessores();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<ProfessorDto> BuscarProfessorPorMatricula(@PathVariable("matricula") String matricula){
        ProfessorDto professorDto = professorService.buscarPorMatricula(matricula);
        return ResponseEntity.ok(professorDto);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<String> deletePorMatricula(@PathVariable("matricula") String matricula){
        professorService.deletePorMatricula(matricula);
        return ResponseEntity.ok("Matricula deletada com sucesso!");
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<ProfessorDto> atualizarProfessor(@PathVariable("matricula")String matricula, @RequestBody @Valid ProfessorDto professorExistente){
        professorService.atualizarProfessor(matricula, professorExistente.toModel());
        return ResponseEntity.ok(professorExistente);
    }
}

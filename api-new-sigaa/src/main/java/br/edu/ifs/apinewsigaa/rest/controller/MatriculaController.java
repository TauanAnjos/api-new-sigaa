package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.model.MatriculaModel;
import br.edu.ifs.apinewsigaa.rest.dto.MatriculaDto;
import br.edu.ifs.apinewsigaa.service.MatriculaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @Operation(
            summary = "Salvar matricula",
            description = "Salva matricula no banco de dados",
            tags = "Matricula"
    )
    @PostMapping
    public ResponseEntity<MatriculaDto> salvarMatricula(@RequestBody MatriculaModel matriculaModel){
        MatriculaDto matriculaDto = matriculaService.salvarMatricula(matriculaModel);
        return ResponseEntity.ok(matriculaDto);
    }

    @Operation(
            summary = "buscar matriculas",
            description = "Buscar todas as matriculas no banco de dados",
            tags = "Matricula"
    )
    @GetMapping
    public ResponseEntity<List<MatriculaDto>> todasMatriculas(){
        List<MatriculaDto> list = matriculaService.todasMatriculas();
        return ResponseEntity.ok(list);

    }

    @Operation(
            summary = "Buscar matricula",
            description = "Buscar matricula, pela matricula, no banco de dados",
            tags = "Matricula"
    )
    @GetMapping("/{matricula}")
    public ResponseEntity<MatriculaDto> buscarMatricula(@PathVariable("matricula") int matricula){
        MatriculaDto matriculaDto = matriculaService.buscarMatricula(matricula);
        return ResponseEntity.ok(matriculaDto);
    }

    @Operation(
            summary = "Deletar matricula",
            description = "Deletar matricula no banco de dados",
            tags = "Matricula"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatricula(@PathVariable("id") int id){
        matriculaService.deleteMatricula(id);
        return ResponseEntity.ok("Matricula deletada com sucesso!");
    }

    @Operation(
            summary = "Atualizar matricula",
            description = "Atualizar matricula no banco de dados",
            tags = "Matricula"
    )
    @PutMapping
    public ResponseEntity<MatriculaDto> atualizarMatricula(@RequestBody @Valid MatriculaDto matriculaDto){
        matriculaService.atualizarMatricula(matriculaDto.toModel());
        return ResponseEntity.ok(matriculaDto);
    }
}

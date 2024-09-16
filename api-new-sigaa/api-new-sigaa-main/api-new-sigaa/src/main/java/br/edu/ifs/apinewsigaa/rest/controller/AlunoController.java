package br.edu.ifs.apinewsigaa.rest.controller;
import br.edu.ifs.apinewsigaa.model.AlunoModel;
import br.edu.ifs.apinewsigaa.rest.dto.AlunoDto;
import br.edu.ifs.apinewsigaa.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/aluno")
@SecurityRequirement(name = "Keycloak")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Operation(
            summary = "Salvar aluno",
            description = "Salva o aluno no banco de dados",
            tags = "Aluno"
    )

    @PostMapping
    public ResponseEntity<AlunoDto> salvarAluno(@RequestBody @Valid AlunoDto aluno){
        AlunoDto alunoDto = alunoService.SalvarAluno(aluno);
        return ResponseEntity.ok(alunoDto);
    }
    @Operation(
            summary = "Buscar lista de alunos",
            description = "Busca todos os alunos no banco de dados",
            tags = "Aluno"
    )

    @GetMapping
    public ResponseEntity<List<AlunoDto>> buscarTodos(){
        List<AlunoDto> list = alunoService.listaDeAlunos();
        return ResponseEntity.ok(list);
    }
    @Operation(
            summary = "Buscar aluno por matricula",
            description = "Busca aluno no banco de dados através da matrícula",
            tags = "Aluno"
    )

    @GetMapping("/{matricula}")
    public ResponseEntity<AlunoDto>ObterPorMatricula(@PathVariable("matricula")String matricula){
        AlunoDto alunoDto = alunoService.ObterPorMatricula(matricula);
        return ResponseEntity.ok(alunoDto);
    }
    @Operation(
            summary = "Deleta aluno",
            description = "Deleta aluno através da matrícula",
            tags = "Aluno"
    )
    @DeleteMapping("/matricula/{matricula}")
    public ResponseEntity<String> deleteByMatricula(@PathVariable("matricula")String matricula){
        alunoService.deletePorMatricula(matricula);
        return ResponseEntity.ok("Matricula deletada com sucesso!");
    }
    @Operation(
            summary = "Deleta aluno",
            description = "Deleta aluno através do ID",
            tags = "Aluno"
    )
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id){
        alunoService.deleteById(id);
        return ResponseEntity.ok("ID deletado com sucesso!");
    }
    @Operation(
            summary = "Atualiza aluno",
            description = "Atualiza um aluno existente no banco de dados",
            tags = "Aluno"
    )
    @PutMapping("/{matricula}")
    public ResponseEntity<AlunoDto> atualizarAluno(@PathVariable("matricula")String matricula, @RequestBody @Valid AlunoDto alunoExistente){
        alunoService.atualizarAluno(matricula,alunoExistente.toModel());
        return ResponseEntity.ok(alunoExistente);
    }
    @Operation(
            summary = "Obter aluno por disciplina",
            description = "Vai trazer todos os alunos através do id da disciplina",
            tags = "Aluno"
    )
    @GetMapping("/obter-por-disciplina/{id}")
    public ResponseEntity<List<AlunoDto>>  obterAlunoPorDisciplina(@PathVariable("id")int id){
        List<AlunoDto> alunosDisciplina = alunoService.obterAlunoPorDisciplina(id);
        return ResponseEntity.ok(alunosDisciplina);
    }

}

package br.edu.ifs.apinewsigaa.rest.controller;
import br.edu.ifs.apinewsigaa.model.AlunoModel;
import br.edu.ifs.apinewsigaa.rest.dto.AlunoDto;
import br.edu.ifs.apinewsigaa.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDto> salvarAluno(@RequestBody AlunoModel aluno){
        AlunoDto alunoDto = alunoService.SalvarAluno(aluno);
        return ResponseEntity.ok(alunoDto);
    }

    @GetMapping
    public ResponseEntity<List<AlunoDto>> buscarTodos(){
        List<AlunoDto> list = alunoService.listaDeAlunos();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<AlunoDto>ObterPorMatricula(@PathVariable("matricula") String matricula){
        AlunoDto alunoDto = alunoService.ObterPorMatricula(matricula);
        return ResponseEntity.ok(alunoDto);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<String> deleteByMatricula(@PathVariable("matricula") String matricula){
        alunoService.deletePorMatricula(matricula);
        return ResponseEntity.ok("Matricula deletada com sucesso!");
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<AlunoDto> atualizarAluno(@PathVariable("matricula")String matricula, @RequestBody AlunoModel alunoModel){
        alunoService.atualizarAluno(matricula, alunoModel);
        return ResponseEntity.ok(alunoModel.toDto());
    }

}

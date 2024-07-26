package br.edu.ifs.apinewsigaa.rest.controller;
import br.edu.ifs.apinewsigaa.rest.dto.AlunoDto;
import br.edu.ifs.apinewsigaa.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{matricula}")
    public ResponseEntity<AlunoDto>ObterPorMatricula(@PathVariable("matricula") String matricula){
        AlunoDto alunoDto = alunoService.ObterPorMatricula(matricula);
        return ResponseEntity.ok(alunoDto);
    }

}

package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.rest.dto.MatriculaDto;
import br.edu.ifs.apinewsigaa.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public ResponseEntity<List<MatriculaDto>> todasMatriculas(){
        List<MatriculaDto> list = matriculaService.todasMatriculas();
        return ResponseEntity.ok(list);

    }

    @GetMapping("/{matricula}")
    public ResponseEntity<MatriculaDto> buscarMatricula(@PathVariable("matricula") int matricula){
        MatriculaDto matriculaDto = matriculaService.buscarMatricula(matricula);
        return ResponseEntity.ok(matriculaDto);
    }
}

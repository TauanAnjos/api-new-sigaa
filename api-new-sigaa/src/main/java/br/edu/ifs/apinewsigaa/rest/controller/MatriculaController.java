package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.model.MatriculaModel;
import br.edu.ifs.apinewsigaa.rest.dto.MatriculaDto;
import br.edu.ifs.apinewsigaa.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<MatriculaDto> salvarMatricula(@RequestBody MatriculaModel matriculaModel){
        MatriculaDto matriculaDto = matriculaService.salvarMatricula(matriculaModel);
        return ResponseEntity.ok(matriculaDto);
    }

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
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatricula(@PathVariable("id") int id){
        matriculaService.deleteMatricula(id);
        return ResponseEntity.ok("Matricula deletada com sucesso!");
    }
}

package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.rest.dto.ProfessorDto;
import br.edu.ifs.apinewsigaa.service.ProfessorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

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

}

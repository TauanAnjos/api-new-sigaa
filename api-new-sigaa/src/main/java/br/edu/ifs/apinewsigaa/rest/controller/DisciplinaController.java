package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaDto;
import br.edu.ifs.apinewsigaa.service.DisciplinaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<DisciplinaDto>> todasDisciplinas(){
        List<DisciplinaDto> list = disciplinaService.TodasDisciplinas();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{nomeDisciplina}")
    public ResponseEntity<DisciplinaDto> buscarDisciplinaNome(@PathVariable("nomeDisciplina") String nome){
        DisciplinaDto disciplinaDto = disciplinaService.BuscarDisciplinaPorNome(nome);
        return ResponseEntity.ok(disciplinaDto);
    }


}

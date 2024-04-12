package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.model.AlunoModel;
import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaDTO;
import br.edu.ifs.apinewsigaa.service.DisciplinaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<DisciplinaModel>saveDisciplina(@RequestBody DisciplinaDTO disciplinaDTO){
        var disciplinaModel = new DisciplinaModel();
        BeanUtils.copyProperties(disciplinaDTO, disciplinaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.saveDisciplina(disciplinaModel));
    }
    @GetMapping
    public List<DisciplinaModel>getAllDisciplina(){
        return disciplinaService.getAllDisciplinas();
    }
    @GetMapping("/{disciplinaId}")
    public ResponseEntity<Object>getOneDisciplina(@PathVariable(value = "disciplinaId")int disciplinaId){
        Optional<DisciplinaModel> disciplinaModel = disciplinaService.getDisciplinaId(disciplinaId);
        if (disciplinaModel.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(disciplinaModel);
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        }
    }
    @PutMapping("/{disciplinaId}")
    public ResponseEntity<Object>updateDisciplina(@PathVariable(value = "disciplinaId")int disciplinaId,@RequestBody DisciplinaDTO disciplinaDTO){
        Optional<DisciplinaModel> disciplinaModel = disciplinaService.getDisciplinaId(disciplinaId);
        if (disciplinaModel.isPresent()){
            DisciplinaModel updateDisciplinaa = disciplinaModel.get();
            updateDisciplinaa.setNome(disciplinaDTO.nome());
            updateDisciplinaa.setNumeroCreditos(disciplinaDTO.numeroCreditos());
            return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.saveDisciplina(updateDisciplinaa));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
    }
    @DeleteMapping("/{disciplinaId}")
    public ResponseEntity<Object>deleteDisciplina(@PathVariable(value = "disciplinaId")int disciplinaId){
        Optional<DisciplinaModel> disciplinaModel = disciplinaService.getDisciplinaId(disciplinaId);
        if (disciplinaModel.isPresent()){
            disciplinaService.deleteDisciplina(disciplinaId);
            return ResponseEntity.status(HttpStatus.OK).body(disciplinaModel);
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        }
    }
}

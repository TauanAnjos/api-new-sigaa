package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.rest.dto.ProfessorDTO;
import br.edu.ifs.apinewsigaa.service.ProfessorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorModel>saveProfessor(@RequestBody ProfessorDTO professorDTO){
        var professorModel = new ProfessorModel();
        BeanUtils.copyProperties(professorDTO,professorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.saveProfessor(professorModel));
    }
    @GetMapping
    public List<ProfessorModel>getAllProfessor(){
        return professorService.getAllProfessor();
    }
    @GetMapping("/{professorId}")
    public ResponseEntity<Object>getOneProfessor(@PathVariable(value = "professorId")int professorId){
        Optional<ProfessorModel> professorModel = professorService.getOneProfessor(professorId);
        if(professorModel.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(professorModel);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        }
    }
    @PutMapping("/{professorId}")
    public ResponseEntity<Object>updateProfessor(@PathVariable(value = "professorId")int professorId,@RequestBody ProfessorDTO professorDTO){
        Optional<ProfessorModel> professorModel = professorService.getOneProfessor(professorId);
        if(professorModel.isPresent()){
            ProfessorModel updateProfessor = professorModel.get();
            updateProfessor.setNome(professorDTO.nome());
            updateProfessor.setCpf(professorDTO.cpf());
            updateProfessor.setDataNascimento(professorDTO.dataNascimento());
            updateProfessor.setEmail(professorDTO.email());
            updateProfessor.setCelular(professorDTO.celular());
            updateProfessor.setMatricula(professorDTO.matricula());
            return ResponseEntity.status(HttpStatus.OK).body(professorService.saveProfessor(updateProfessor));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
    }
    @DeleteMapping("/{professorId}")
    public ResponseEntity<Object>deleteProfessor(@PathVariable(value = "professorId")int professorId){
        Optional<ProfessorModel> professorModel = professorService.getOneProfessor(professorId);
        if(professorModel.isPresent()){
            professorService.deleteProfessor(professorId);
            return ResponseEntity.status(HttpStatus.OK).body(professorModel);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        }
    }
}

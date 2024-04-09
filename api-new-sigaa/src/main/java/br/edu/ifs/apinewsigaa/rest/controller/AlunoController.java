package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.model.AlunoModel;
import br.edu.ifs.apinewsigaa.repository.AlunoRepository;
import br.edu.ifs.apinewsigaa.rest.dto.AlunoDTO;
import br.edu.ifs.apinewsigaa.service.AlunoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoModel> saveAluno(@RequestBody  AlunoDTO alunoDTO){
        var alunoModel = new AlunoModel();
        BeanUtils.copyProperties(alunoDTO, alunoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.saveAluno(alunoModel));
    }
    @GetMapping
    public List<AlunoModel> getAllAluno(){
        return alunoService.getAllAlunos();
    }
    @GetMapping("/{alunoId}")
    public ResponseEntity<Object>getAlunoId(@PathVariable(value = "alunoId")int alunoID){
        Optional<AlunoModel> alunoModel = alunoService.getAlunoId(alunoID);
        if (alunoModel.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(alunoModel);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        }
    }

    @PutMapping("/{alunoId}")
    public ResponseEntity<Object>updateAluno(@PathVariable(value = "alunoId")int alunoID,@RequestBody AlunoDTO alunoDTO){
        Optional<AlunoModel> alunoModel = alunoService.getAlunoId(alunoID);
        if(alunoModel.isPresent()){
            AlunoModel updateAlunoo = alunoModel.get();
            updateAlunoo.setNome(alunoDTO.nome());
            updateAlunoo.setCpf(alunoDTO.cpf());
            updateAlunoo.setEmail(alunoDTO.email());
            updateAlunoo.setDataNascimento(alunoDTO.dataNascimento());
            updateAlunoo.setCelular(alunoDTO.celular());
            updateAlunoo.setApelido(alunoDTO.apelido());
            updateAlunoo.setMatricula(alunoDTO.matricula());
            alunoService.saveAluno(updateAlunoo);
           return ResponseEntity.status(HttpStatus.OK).body(updateAlunoo);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
    }
    @DeleteMapping("/{alunoId}")
    public ResponseEntity<Object>deleteAluno(@PathVariable(value = "alunoId")int alunoID){
        Optional<AlunoModel> alunoModel = alunoService.getAlunoId(alunoID);
        if (alunoModel.isPresent()){
            alunoService.deleteAluno(alunoID);
            return ResponseEntity.status(HttpStatus.OK).body(alunoModel);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        }
    }
}

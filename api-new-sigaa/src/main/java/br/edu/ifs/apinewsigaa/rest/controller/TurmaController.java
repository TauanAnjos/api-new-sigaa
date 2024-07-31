package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.model.TurmaModel;
import br.edu.ifs.apinewsigaa.rest.dto.TurmaDto;
import br.edu.ifs.apinewsigaa.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<TurmaDto> salvarTurma(@RequestBody TurmaModel turmaModel){
        TurmaDto turmaDto = turmaService.salvarTurma(turmaModel);
        return ResponseEntity.ok(turmaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaDto> buscarPorId(@PathVariable("id") int id){
        TurmaDto turmaDto = turmaService.buscarTurmaPorId(id);
        return ResponseEntity.ok(turmaDto);
    }
    @GetMapping
    public ResponseEntity<List<TurmaDto>> findaAll(){
        List<TurmaDto> list = turmaService.buscarTurmas();
        return ResponseEntity.ok(list);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTurma(@PathVariable("id") int id){
        turmaService.deleteTurma(id);
        return ResponseEntity.ok("Turma deletada com sucesso!");
    }
}

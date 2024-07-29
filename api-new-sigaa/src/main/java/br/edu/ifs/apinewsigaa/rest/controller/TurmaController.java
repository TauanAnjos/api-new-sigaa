package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.rest.dto.TurmaDto;
import br.edu.ifs.apinewsigaa.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

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
}

package br.edu.ifs.apinewsigaa.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AlunoController {

    @GetMapping("/aluno")
    public String getAll(){
        return "Relampago marquinhos";
    }


}

package br.edu.ifs.apinewsigaa.rest.dto;

import br.edu.ifs.apinewsigaa.model.AlunoModel;
import lombok.Data;

import java.util.Date;

public record AlunoDTO(String nome, String cpf, String email, Date dataNascimento, String celular, String apelido, int matricula) {
    public AlunoModel toAlunoDTO(){
        return new AlunoModel(nome, cpf, email, dataNascimento, celular, apelido, matricula);
    }
}

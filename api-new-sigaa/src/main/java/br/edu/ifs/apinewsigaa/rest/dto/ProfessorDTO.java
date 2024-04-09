package br.edu.ifs.apinewsigaa.rest.dto;

import lombok.Data;

import java.util.Date;

public record ProfessorDTO(String nome, String cpf, Date dataNascimento, String email, String celular, int matricula) {
}

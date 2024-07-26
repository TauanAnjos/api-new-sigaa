package br.edu.ifs.apinewsigaa.rest.dto;

import jakarta.persistence.Column;

import java.util.Date;

public class ProfessorDto {
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;
    @Column(name = "dataNascimento", nullable = false)
    private Date dataNascimento;
    @Column(name = "email",length = 255, nullable = false, unique = true)
    private String email;
    @Column(name = "celular", length = 14, nullable = false, unique = true)
    private String celular;
    @Column(name = "matricula", nullable = false, unique = true)
    private int matricula;
}
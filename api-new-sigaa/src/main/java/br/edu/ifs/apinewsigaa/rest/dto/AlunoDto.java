package br.edu.ifs.apinewsigaa.rest.dto;



import jakarta.persistence.Column;

import java.util.Date;

public class AlunoDto {

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;
    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;
    @Column(name = "dataNascimento", nullable = false)
    private Date dataNascimento;
    @Column(name = "celular", length = 14, nullable = false, unique = true)
    private String celular;
    @Column(name = "apelido", length = 255, nullable = true)
    private String apelido;
    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;
}
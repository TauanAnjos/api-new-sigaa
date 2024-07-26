package br.edu.ifs.apinewsigaa.rest.dto;


import jakarta.persistence.Column;

public class DisciplinaDto {
    @Column(name = "nome", length = 255, nullable = false, unique = true)
    private String nome;
    @Column(name = "numeroCreditos", nullable = false)
    private byte numeroCreditos;
}

package br.edu.ifs.apinewsigaa.rest.dto;


import jakarta.persistence.Column;

public class MatriculaDto {
    @Column(name = "idAluno", nullable = false)
    private int idAluno;
    @Column(name = "idTurma", nullable = false)
    private int idTurma;
}

package br.edu.ifs.apinewsigaa.rest.dto;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MatriculaDto {
    @Column(name = "idAluno", nullable = false)
    private int idAluno;
    @Column(name = "idTurma", nullable = false)
    private int idTurma;
}

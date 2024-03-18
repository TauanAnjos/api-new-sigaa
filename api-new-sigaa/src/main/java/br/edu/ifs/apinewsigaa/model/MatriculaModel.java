package br.edu.ifs.apinewsigaa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "matricula")
public class MatriculaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idAluno", nullable = false, unique = true)
    private int idAluno;
    @Column(name = "idTurma", nullable = false, unique = true)
    private int idTurma;
}

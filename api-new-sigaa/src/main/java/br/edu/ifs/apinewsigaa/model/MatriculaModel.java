package br.edu.ifs.apinewsigaa.model;

import br.edu.ifs.apinewsigaa.rest.dto.MatriculaDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "matricula")
public class MatriculaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idAluno", nullable = false)
    private int idAluno;
    @Column(name = "idTurma", nullable = false)
    private int idTurma;

    public MatriculaDto toDto(){
        return new MatriculaDto();
    }
}

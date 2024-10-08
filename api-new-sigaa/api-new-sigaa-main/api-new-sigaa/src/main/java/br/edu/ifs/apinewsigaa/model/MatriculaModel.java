package br.edu.ifs.apinewsigaa.model;

import br.edu.ifs.apinewsigaa.rest.dto.MatriculaDto;
import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
@Entity
@Table(name = "matricula")
public class MatriculaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "idAluno", nullable = false)
    private AlunoModel aluno;
    @ManyToOne
    @JoinColumn(name = "idTurma", nullable = false)
    private TurmaModel turma;

    public MatriculaDto toDto(){
        var modelMapper = new ModelMapper();
        return modelMapper.map(this, MatriculaDto.class);
    }
}

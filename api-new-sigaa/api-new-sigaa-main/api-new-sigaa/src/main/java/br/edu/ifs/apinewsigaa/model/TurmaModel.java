package br.edu.ifs.apinewsigaa.model;

import br.edu.ifs.apinewsigaa.rest.dto.TurmaDto;
import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "turma")
public class TurmaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dataInicio", nullable = false)
    private Date dataInicio;
    @Column(name = "dataFim", nullable = false)
    private Date dataFim;
    @ManyToOne
    @JoinColumn(name = "idProfessor", nullable = true)
    private ProfessorModel idProfessor;
    @ManyToOne
    @JoinColumn(name = "idDisciplina", nullable = true)
    private DisciplinaModel idDisciplina;
    @OneToMany(mappedBy = "turma")
    private List<MatriculaModel> matriculas;

    public TurmaDto toDto(){
        var modelMapper = new ModelMapper();
        return modelMapper.map(this, TurmaDto.class);
    }
}

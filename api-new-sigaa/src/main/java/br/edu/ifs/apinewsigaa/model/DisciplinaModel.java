package br.edu.ifs.apinewsigaa.model;

import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaDto;
import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "disciplina")
public class DisciplinaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome", length = 255, nullable = false, unique = true)
    private String nome;
    @Column(name = "numeroCreditos", nullable = false)
    private byte numeroCreditos;
    @ManyToOne
    @JoinColumn(name = "idProfessor")
    private ProfessorModel professor;
    @OneToMany(mappedBy = "disciplina")
    private List<AlunoModel> alunos;

    public DisciplinaDto toDto(){
        var modelMapper = new ModelMapper();
        DisciplinaDto dto = modelMapper.map(this, DisciplinaDto.class);

        if(this.alunos != null){
            dto.setAlunos(this.alunos.stream().map(AlunoModel::toDto).collect(Collectors.toList()));
        }
        return dto;
    }

}

package br.edu.ifs.apinewsigaa.model;

import br.edu.ifs.apinewsigaa.rest.dto.AlunoDto;
import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "aluno")
public class AlunoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
    @ManyToOne
    @JoinColumn(name = "idDisciplina")
    private DisciplinaModel disciplina;
    @OneToMany(mappedBy = "aluno")
    private List<MatriculaModel> matriculas;

    public AlunoDto toDto(){
        var modelMapper = new ModelMapper();
        return modelMapper.map(this, AlunoDto.class);
    }
}

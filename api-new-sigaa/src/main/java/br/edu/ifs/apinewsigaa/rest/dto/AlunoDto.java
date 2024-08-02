package br.edu.ifs.apinewsigaa.rest.dto;



import br.edu.ifs.apinewsigaa.model.AlunoModel;
import jakarta.persistence.Column;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Date;
@Data
public class AlunoDto {

    private String nome;
    private String cpf;
    private String email;
    private Date dataNascimento;
    private String celular;
    private String apelido;
    private String matricula;

    public AlunoModel toModel(){
        var modelMapper = new ModelMapper();
        return modelMapper.map(this, AlunoModel.class);
    }
}

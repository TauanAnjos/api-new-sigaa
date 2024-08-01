package br.edu.ifs.apinewsigaa.rest.dto;

import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import lombok.Data;
import java.util.Date;
@Data
public class ProfessorDto {

    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String email;
    private String celular;
    private int matricula;

    public ProfessorModel toModel(){
        return new ProfessorModel();
    }
}

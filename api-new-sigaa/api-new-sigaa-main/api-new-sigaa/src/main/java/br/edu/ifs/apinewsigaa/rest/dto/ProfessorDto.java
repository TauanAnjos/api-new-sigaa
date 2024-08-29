package br.edu.ifs.apinewsigaa.rest.dto;

import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;

@Data
public class ProfessorDto {

    @NotBlank(message = "Campo nome é obrigatório!")
    private String nome;
    @CPF(message = "CPF inválido!")
    @NotBlank(message = "CPF inválido! Formato CPF(000.000.000-00")
    private String cpf;
    @NotNull(message = "Campo data de nascimento é obrigatório!")
    @Past(message = "Digite uma data de nascimento válida!")
    private Date dataNascimento;
    @Email(message = "Email inválido!")
    @NotBlank(message = "Campo email é obrigatório!")
    private String email;
    @NotBlank(message = "Campo celular é obrigatório!")
    @Size(max = 14, message = "Celular inválido!")
    private String celular;
    @NotBlank(message = "Campo matricula é obrigatório!")
    private String matricula;

    private List<DisciplinaDto> disciplinas;

    public ProfessorModel toModel(){
        var modelMapper = new ModelMapper();
        return modelMapper.map(this, ProfessorModel.class);
    }
}

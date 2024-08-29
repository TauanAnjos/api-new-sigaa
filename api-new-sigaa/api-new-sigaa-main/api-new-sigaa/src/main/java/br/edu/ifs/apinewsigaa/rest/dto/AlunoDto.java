package br.edu.ifs.apinewsigaa.rest.dto;



import br.edu.ifs.apinewsigaa.model.AlunoModel;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.modelmapper.ModelMapper;

import java.util.Date;
@Data
public class AlunoDto {

    @NotBlank(message = "Campo nome é obrigatório!")
    private String nome;
    @CPF(message = "CPF inválido! Formato CPF(000.000.000-00")
    @NotBlank(message = "Campo cpf é obrigatório!")
    private String cpf;
    @Email(message = "Email inválido!")
    @NotBlank(message = "Campo email é obrigatório!")
    private String email;
    @NotNull(message = "Campo data de Nascimento é obrigatório!")
    @Past(message = "Digite uma data de nascimento válida!")
    private Date dataNascimento;
    @Size(max = 14, message = "Celular inválido!")
    @NotBlank(message = "Campo celular é obrigatório!")
    private String celular;
    private String apelido;
    @NotBlank(message = "Campo de matricula obrigatório!")
    private String matricula;

    public AlunoModel toModel(){
        var modelMapper = new ModelMapper();
        return modelMapper.map(this, AlunoModel.class);
    }
}

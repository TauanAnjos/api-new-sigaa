package br.edu.ifs.apinewsigaa.rest.dto;


import br.edu.ifs.apinewsigaa.model.DisciplinaModel;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class DisciplinaDto {

    @NotBlank(message = "Campo nome é obrigatório!")
    private String nome;
    @NotBlank(message = "Campo número de creditos é obrigatório!")
    @Size(min = 1, message = "Número de créditos não pode ser menor que 1")
    private byte numeroCreditos;

    List<AlunoDto> alunos;

    public DisciplinaModel toModel(){
        var modelMapper = new ModelMapper();
        return modelMapper.map(this, DisciplinaModel.class);
    }
}

package br.edu.ifs.apinewsigaa.rest.dto;

import br.edu.ifs.apinewsigaa.model.TurmaModel;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Date;
@Data
public class TurmaDto {
    @NotNull(message = "Data de inicio obrigatório!")
    private Date dataInicio;
    @NotNull(message = "Data de inicio obrigatório!")
    private Date dataFim;
    @NotNull(message = "Campo ID professor é obrigatório!")
    @Positive(message = "ID professor precisa ser positivos!")
    private int idProfessor;
    @NotNull(message = "Campo ID disciplina é obrigatório!")
    @Positive(message = "ID disciplina precisa ser positivos!")
    private int idDisciplina;

    public TurmaModel toModel(){
        var modelMapper = new ModelMapper();
        return modelMapper.map(this, TurmaModel.class);
    }
}

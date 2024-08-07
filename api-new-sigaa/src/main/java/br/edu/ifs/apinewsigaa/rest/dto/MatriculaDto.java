package br.edu.ifs.apinewsigaa.rest.dto;


import br.edu.ifs.apinewsigaa.model.MatriculaModel;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class MatriculaDto {

    @NotNull(message = "Campo de ID aluno é obrigatório!")
    @Positive(message = "ID aluno precisa ser positivos!")
    private int idAluno;
    @NotNull(message = "Campo ID turma é obrigatório!")
    @Positive(message = "ID turma precisa ser positivos!")
    private int idTurma;

    public MatriculaModel toModel(){
        var modelMapper = new ModelMapper();
        return modelMapper.map(this, MatriculaModel.class);
    }
}

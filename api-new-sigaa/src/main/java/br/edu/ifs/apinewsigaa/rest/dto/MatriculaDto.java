package br.edu.ifs.apinewsigaa.rest.dto;


import br.edu.ifs.apinewsigaa.model.MatriculaModel;
import jakarta.persistence.Column;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class MatriculaDto {

    private int idAluno;
    private int idTurma;

    public MatriculaModel toModel(){
        var modelMapper = new ModelMapper();
        return modelMapper.map(this, MatriculaModel.class);
    }
}

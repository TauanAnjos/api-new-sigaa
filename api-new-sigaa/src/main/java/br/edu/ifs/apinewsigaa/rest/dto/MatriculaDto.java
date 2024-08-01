package br.edu.ifs.apinewsigaa.rest.dto;


import br.edu.ifs.apinewsigaa.model.MatriculaModel;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MatriculaDto {

    private int idAluno;
    private int idTurma;

    public MatriculaModel toModel(){
        return new MatriculaModel();
    }
}

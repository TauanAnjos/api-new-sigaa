package br.edu.ifs.apinewsigaa.rest.dto;


import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DisciplinaDto {

    private String nome;
    private byte numeroCreditos;

    public DisciplinaModel toModel(){
        return new DisciplinaModel();
    }
}

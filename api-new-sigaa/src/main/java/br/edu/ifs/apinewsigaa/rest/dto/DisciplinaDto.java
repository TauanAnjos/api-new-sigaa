package br.edu.ifs.apinewsigaa.rest.dto;


import br.edu.ifs.apinewsigaa.model.DisciplinaModel;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class DisciplinaDto {

    private String nome;
    private byte numeroCreditos;

    public DisciplinaModel toModel(){
        var modelMapper = new ModelMapper();
        return modelMapper.map(this, DisciplinaModel.class);
    }
}

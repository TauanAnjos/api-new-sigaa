package br.edu.ifs.apinewsigaa.rest.dto;

import br.edu.ifs.apinewsigaa.model.TurmaModel;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
@Data
public class TurmaDto {

    private Date dataInicio;
    private Date dataFim;
    private int idProfessor;
    private int idDisciplina;

    public TurmaModel toModel(){
        return new TurmaModel();
    }
}

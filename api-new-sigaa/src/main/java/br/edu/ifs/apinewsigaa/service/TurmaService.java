package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.TurmaModel;
import br.edu.ifs.apinewsigaa.repository.TurmaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.TurmaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TurmaDto buscarTurmaPorId(int id){
        Optional<TurmaModel> turmaOptional = turmaRepository.findById(id);
        TurmaModel turmaModel = turmaOptional.orElseThrow(() -> new ObjectNotFoundException("Erro: Turma não encontrada! ID Turma: " + id));
        return modelMapper.map(turmaModel, TurmaDto.class);
    }

}

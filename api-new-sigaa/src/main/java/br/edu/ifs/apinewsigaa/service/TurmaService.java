package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.TurmaModel;
import br.edu.ifs.apinewsigaa.repository.TurmaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.TurmaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TurmaDto salvarTurma(TurmaModel turmaModel){
        turmaRepository.save(turmaModel);
        return modelMapper.map(turmaModel, TurmaDto.class);
    }

    public TurmaDto buscarTurmaPorId(int id){
        Optional<TurmaModel> turmaOptional = turmaRepository.findById(id);
        TurmaModel turmaModel = turmaOptional.orElseThrow(() -> new ObjectNotFoundException("Erro: Turma não encontrada! ID Turma: " + id));
        return modelMapper.map(turmaModel, TurmaDto.class);
    }

    public List<TurmaDto> buscarTurmas(){
        List<TurmaModel> list = turmaRepository.findAll();
        return list.stream().map(turmas -> modelMapper.map(turmas, TurmaDto.class)).collect(Collectors.toList());
    }

    public void deleteTurma(int id){
        TurmaModel turma = turmaRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Erro: ID de turma não encontrado! ID: "+ id ));
        turmaRepository.deleteById(id);
    }

}

package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.exception.DataIntegrityException;
import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.TurmaModel;
import br.edu.ifs.apinewsigaa.repository.TurmaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.TurmaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.edu.ifs.apinewsigaa.exception.DataIntegrityException.extrairErro;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Transactional
    public TurmaDto salvarTurma(TurmaModel turmaModel){
        try{
            return turmaRepository.save(turmaModel).toDto();
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException(extrairErro(e));
        }
    }
    @Transactional(readOnly = true)
    public TurmaDto buscarTurmaPorId(int id){
        Optional<TurmaModel> turmaOptional = turmaRepository.findById(id);
        TurmaModel turmaModel = turmaOptional.orElseThrow(() -> new ObjectNotFoundException("Erro: Turma não encontrada! ID Turma: " + id));
        return turmaModel.toDto();
    }
    @Transactional(readOnly = true)
    public List<TurmaDto> buscarTurmas(){
        List<TurmaModel> list = turmaRepository.findAll();
        return list.stream().map(turmas -> turmas.toDto()).collect(Collectors.toList());
    }
    @Transactional
    public void deleteTurma(int id){
        TurmaModel turma = turmaRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Erro: ID de turma não encontrado! ID: "+ id));
        turmaRepository.deleteById(id);
    }

}

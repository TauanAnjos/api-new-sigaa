package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.exception.DataIntegrityException;
import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.AlunoModel;
import br.edu.ifs.apinewsigaa.repository.AlunoRepository;
import br.edu.ifs.apinewsigaa.rest.dto.AlunoDto;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.edu.ifs.apinewsigaa.exception.DataIntegrityException.extrairErro;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public AlunoDto SalvarAluno(AlunoModel alunoModel){
       try{
           return alunoRepository.save(alunoModel).toDto();
       }catch (DataIntegrityViolationException e){
           throw new DataIntegrityException(extrairErro(e));
       }
    }
    @Transactional(readOnly = true)
    public AlunoDto ObterPorMatricula(String matricula){
        Optional<AlunoModel> alunoOptional = alunoRepository.findByMatricula(matricula);
        AlunoModel alunoModel = alunoOptional.orElseThrow(() ->
                new ObjectNotFoundException("ERRO: Matricula não encontrada! Matricula: " + matricula));
        return alunoModel.toDto();
    }
    @Transactional(readOnly = true)
    public List<AlunoDto> listaDeAlunos(){
        List<AlunoModel> listAluno= alunoRepository.findAll();
        return listAluno.stream().map(aluno -> aluno.toDto()).collect(Collectors.toList());
    }
    @Transactional
    public void deletePorMatricula(String matricula){
        AlunoModel aluno = alunoRepository.findByMatricula(matricula).
                orElseThrow(() -> new ObjectNotFoundException("Erro: Matricula não encontrada! Matricula: " + matricula));
        alunoRepository.deleteByMatricula(aluno.getMatricula());
    }

    public AlunoDto atualizarAluno(String matricula, AlunoModel alunoModel){
        AlunoModel alunoExistente = alunoRepository.findByMatricula(matricula).orElseThrow(()->
                new ObjectNotFoundException("Erro: Matricula não encontrada! Matricula: " + matricula));
        alunoModel.setId(alunoExistente.getId());
        try {
            return alunoRepository.save(alunoModel).toDto();
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException(extrairErro(e));
        }
    }


}

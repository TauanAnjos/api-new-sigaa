package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.AlunoModel;
import br.edu.ifs.apinewsigaa.repository.AlunoRepository;
import br.edu.ifs.apinewsigaa.rest.dto.AlunoDto;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public AlunoDto ObterPorMatricula(String matricula){
        Optional<AlunoModel> alunoOptional = alunoRepository.findByMatricula(matricula);
        AlunoModel alunoModel = alunoOptional.orElseThrow(() ->
                new ObjectNotFoundException("ERRO: Matricula não encontrada! Matricula: " + matricula));
        return modelMapper.map(alunoModel, AlunoDto.class);
    }

    public List<AlunoDto> listaDeAlunos(){
        List<AlunoModel> listAluno= alunoRepository.findAll();
        return listAluno.stream().map(aluno -> modelMapper.map(aluno, AlunoDto.class)).collect(Collectors.toList());
    }
    @Transactional
    public void deletePorMatricula(String matricula){
        AlunoModel aluno = alunoRepository.findByMatricula(matricula).
                orElseThrow(() -> new ObjectNotFoundException("Erro: Matricula não encontrada! Matricula: " + matricula));
        alunoRepository.deleteByMatricula(aluno.getMatricula());
    }
}

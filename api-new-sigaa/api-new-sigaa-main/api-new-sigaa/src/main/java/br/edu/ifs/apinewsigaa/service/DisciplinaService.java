package br.edu.ifs.apinewsigaa.service;


import br.edu.ifs.apinewsigaa.exception.DataIntegrityException;
import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import br.edu.ifs.apinewsigaa.repository.DisciplinaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaDto;
import io.swagger.v3.oas.annotations.Operation;
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
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Transactional
    public DisciplinaDto salvarDisciplina(DisciplinaDto disciplinaDto){
        try{
            return disciplinaRepository.save(disciplinaDto.toModel()).toDto();
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException(extrairErro(e));
        }
    }

    @Transactional(readOnly = true)
    public DisciplinaDto BuscarDisciplinaPorNome(String nome){
        Optional<DisciplinaModel> nomeDisciplina = disciplinaRepository.findByNome(nome);
        DisciplinaModel disciplinaModel = nomeDisciplina.orElseThrow(() ->
                new ObjectNotFoundException("Error: Disciplina não encontrada! Disciplina: " + nome));
        return disciplinaModel.toDto();
    }
    @Transactional(readOnly = true)
    public List<DisciplinaDto> TodasDisciplinas(){
        List<DisciplinaModel> list = disciplinaRepository.findAll();
        return list.stream().map(disciplina -> disciplina.toDto()).collect(Collectors.toList());
    }

    @Transactional
    public void deleteDisciplinaPorId(int id){
        DisciplinaModel disciplina = disciplinaRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Erro: Disciplina não encontrada! ID disicplina: " + id));
        disciplinaRepository.deleteById(id);
    }
    @Transactional
    public DisciplinaDto atualizarDisciplina(DisciplinaModel disciplinaExistente){
        if(disciplinaRepository.existsById(disciplinaExistente.getId())) {
            try {
                return disciplinaRepository.save(disciplinaExistente).toDto();
            } catch (DataIntegrityViolationException e) {
                throw new DataIntegrityException(extrairErro(e));
            }
        }else {
            throw new ObjectNotFoundException("Disciplina não encontrada");
        }
    }
}

package br.edu.ifs.apinewsigaa.service;


import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import br.edu.ifs.apinewsigaa.repository.DisciplinaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DisciplinaDto BuscarDisciplinaPorNome(String nome){
        Optional<DisciplinaModel> nomeDisciplina = disciplinaRepository.findByNome(nome);
        DisciplinaModel disciplinaModel = nomeDisciplina.orElseThrow(() ->
                new ObjectNotFoundException("Error: Disciplina não encontrada! Disciplina: " + nome));
        return modelMapper.map(disciplinaModel, DisciplinaDto.class);
    }

    public List<DisciplinaDto> TodasDisciplinas(){
        List<DisciplinaModel> list = disciplinaRepository.findAll();
        return list.stream().map(disciplina -> modelMapper.map(disciplina, DisciplinaDto.class)).collect(Collectors.toList());
    }
}

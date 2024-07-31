package br.edu.ifs.apinewsigaa.service;


import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import br.edu.ifs.apinewsigaa.repository.DisciplinaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaDto;
import jakarta.transaction.Transactional;
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

    public DisciplinaDto salvarDisciplina(DisciplinaModel disciplinaModel){
        disciplinaRepository.save(disciplinaModel);
        return modelMapper.map(disciplinaModel, DisciplinaDto.class);
    }

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


    public void deleteDisciplinaPorId(int id){
        DisciplinaModel disciplina = disciplinaRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Erro: Disciplina não encontrada! ID disicplina: " + id));
        disciplinaRepository.deleteById(id);
    }

    public DisciplinaDto atualizarDisciplina(String nome, DisciplinaDto disciplinaDto){
        DisciplinaModel disciplinaModel = disciplinaRepository.findByNome(nome).orElseThrow(()->
                new ObjectNotFoundException("Erro: Disciplina não encontrada! ID disicplina: " + nome));

        disciplinaModel.setNome(disciplinaDto.getNome());
        disciplinaModel.setNumeroCreditos(disciplinaDto.getNumeroCreditos());

        disciplinaRepository.save(disciplinaModel);

        return modelMapper.map(disciplinaModel, DisciplinaDto.class);
    }
}

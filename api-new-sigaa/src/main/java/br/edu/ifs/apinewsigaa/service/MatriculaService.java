package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.MatriculaModel;
import br.edu.ifs.apinewsigaa.repository.MatriculaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.MatriculaDto;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MatriculaDto buscarMatricula(int matricula){
        Optional<MatriculaModel> matriculaOptional = matriculaRepository.findById(matricula);
        MatriculaModel matriculaModel = matriculaOptional.orElseThrow(() ->
                new ObjectNotFoundException("Erro: Matricula não encontrada! Matricula: " + matricula));
        return modelMapper.map(matriculaModel, MatriculaDto.class);
    }

    public List<MatriculaDto> todasMatriculas(){
        List<MatriculaModel> list = matriculaRepository.findAll();
        return list.stream().map(matricula -> modelMapper.map(matricula, MatriculaDto.class)).collect(Collectors.toList());
    }
    public void deleteMatricula(int id){
        MatriculaModel matriculaModel = matriculaRepository.findById(id).orElseThrow(()->
                new ObjectNotFoundException("Erro: ID de matricula não encontrado! ID: " + id));
        matriculaRepository.deleteById(id);
    }
}

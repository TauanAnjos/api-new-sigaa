package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.exception.DataIntegrityException;
import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.MatriculaModel;
import br.edu.ifs.apinewsigaa.repository.MatriculaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.MatriculaDto;
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
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public MatriculaDto salvarMatricula(MatriculaModel matriculaModel){
      try{
          return matriculaRepository.save(matriculaModel).toDto();
      }catch (DataIntegrityViolationException e){
          throw new DataIntegrityException(extrairErro(e));
      }
    }
    @Transactional(readOnly = true)
    public MatriculaDto buscarMatricula(int id){
        Optional<MatriculaModel> matriculaOptional = matriculaRepository.findById(id);
        MatriculaModel matriculaModel = matriculaOptional.orElseThrow(() ->
                new ObjectNotFoundException("Erro: Matricula não encontrada! Matricula: " + id));
        return matriculaModel.toDto();
    }
    @Transactional(readOnly = true)
    public List<MatriculaDto> todasMatriculas(){
        List<MatriculaModel> list = matriculaRepository.findAll();
        return list.stream().map(matricula -> matricula.toDto()).collect(Collectors.toList());
    }
    @Transactional
    public void deleteMatricula(int id){
        MatriculaModel matriculaModel = matriculaRepository.findById(id).orElseThrow(()->
                new ObjectNotFoundException("Erro: ID de matricula não encontrado! ID: " + id));
        matriculaRepository.deleteById(id);
    }

}

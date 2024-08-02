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

    public MatriculaDto salvarMatricula(MatriculaModel matriculaModel){
      try{
          return matriculaRepository.save(matriculaModel).toDto();
      }catch (DataIntegrityViolationException e){
          throw new DataIntegrityException(extrairErro(e));
      }
    }

    public MatriculaDto buscarMatricula(int id){
        Optional<MatriculaModel> matriculaOptional = matriculaRepository.findById(id);
        MatriculaModel matriculaModel = matriculaOptional.orElseThrow(() ->
                new ObjectNotFoundException("Erro: Matricula não encontrada! Matricula: " + id));
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

    public MatriculaDto atualizarMatricula(int id, MatriculaModel matriculaModel){
        MatriculaModel matriculaExistente = matriculaRepository.findById(id).orElseThrow(()->
                new ObjectNotFoundException("Erro: ID de matricula não encontrado! ID: " + id));
        matriculaModel.setId(matriculaExistente.getId());
        try {
            return matriculaRepository.save(matriculaModel).toDto();
        }catch (DataIntegrityViolationException e){
            throw  new DataIntegrityException(extrairErro(e));
        }
    }
}

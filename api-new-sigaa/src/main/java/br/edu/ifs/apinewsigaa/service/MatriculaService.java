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

    public MatriculaDto salvarMatricula(MatriculaModel matriculaModel){
        matriculaRepository.save(matriculaModel);
        return modelMapper.map(matriculaModel, MatriculaDto.class);
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

    public MatriculaDto atualizarMatricula(int id, MatriculaDto matriculaDto){
        MatriculaModel matriculaModel = matriculaRepository.findById(id).orElseThrow(()->
                new ObjectNotFoundException("Erro: ID de matricula não encontrado! ID: " + id));

        matriculaModel.setIdAluno(matriculaDto.getIdAluno());
        matriculaModel.setIdTurma(matriculaDto.getIdTurma());

        matriculaRepository.save(matriculaModel);

        return modelMapper.map(matriculaModel, MatriculaDto.class);
    }
}

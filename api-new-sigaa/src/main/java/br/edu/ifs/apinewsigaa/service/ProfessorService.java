package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.repository.ProfessorRepository;
import br.edu.ifs.apinewsigaa.rest.dto.ProfessorDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ProfessorDto buscarPorMatricula(String matricula){
        Optional<ProfessorModel> professorOptional = professorRepository.findByMatricula(matricula);
        ProfessorModel professorModel = professorOptional.orElseThrow(() ->
                new ObjectNotFoundException("Error: Matricula não encontrada! Matricula: " + matricula));
        return modelMapper.map(professorModel, ProfessorDto.class);
    }

    public List<ProfessorDto> todosProfessores(){
        List<ProfessorModel> list = professorRepository.findAll();
        return list.stream().map(professores -> modelMapper.map(professores, ProfessorDto.class)).collect(Collectors.toList());
    }
}

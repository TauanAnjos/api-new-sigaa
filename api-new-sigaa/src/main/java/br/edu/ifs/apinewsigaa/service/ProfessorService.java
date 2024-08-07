package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.exception.DataIntegrityException;
import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.repository.ProfessorRepository;
import br.edu.ifs.apinewsigaa.rest.dto.ProfessorDto;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import static br.edu.ifs.apinewsigaa.exception.DataIntegrityException.extrairErro;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public ProfessorDto salvarProfessor(ProfessorModel professorModel){
        try{
            return professorRepository.save(professorModel).toDto();
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityException(extrairErro(e));
        }
    }
    @Transactional(readOnly = true)
    public ProfessorDto buscarPorMatricula(String matricula){
        Optional<ProfessorModel> professorOptional = professorRepository.findByMatricula(matricula);
        ProfessorModel professorModel = professorOptional.orElseThrow(() ->
                new ObjectNotFoundException("Error: Matricula não encontrada! Matricula: " + matricula));
        return professorModel.toDto();
    }
    @Transactional(readOnly = true)
    public List<ProfessorDto> todosProfessores(){
        List<ProfessorModel> list = professorRepository.findAll();
        return list.stream().map(professores -> professores.toDto()).collect(Collectors.toList());
    }

    @Transactional
    public void deletePorMatricula(String matricula){
        ProfessorModel professor = professorRepository.findByMatricula(matricula).orElseThrow(() ->
                new ObjectNotFoundException("Erro: Matricula não encontrada! Matricula: " + matricula));
        professorRepository.deleteByMatricula(professor.getMatricula());
    }
    @Transactional
    public ProfessorDto atualizarProfessor(String matricula, ProfessorModel professorModel){
        ProfessorModel professorExistente = professorRepository.findByMatricula(matricula).orElseThrow(()->
                new ObjectNotFoundException("Erro: Matricula não encontrada! Matricula: " + matricula));
        professorModel.setId(professorExistente.getId());
        try{
            return professorRepository.save(professorModel).toDto();
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException(extrairErro(e));
        }

    }
    @Transactional
    public void deleteById(int id) {
        if (professorRepository.existsById(id)){
            professorRepository.deleteById(id);
        }else {
            throw new ObjectNotFoundException("ID não encontrado!");
        }
    }
}

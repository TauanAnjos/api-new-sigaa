package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorModel saveProfessor(ProfessorModel professorModel) {
        return professorRepository.save(professorModel);
    }

    public List<ProfessorModel> getAllProfessor() {
        return professorRepository.findAll();
    }

    public Optional<ProfessorModel> getOneProfessor(int professorId) {
        return professorRepository.findById(professorId);
    }

    public void deleteProfessor(int professorModel) {
        professorRepository.deleteById(professorModel);
    }
}

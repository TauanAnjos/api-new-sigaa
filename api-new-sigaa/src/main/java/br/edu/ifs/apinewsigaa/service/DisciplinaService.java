package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import br.edu.ifs.apinewsigaa.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public DisciplinaModel saveDisciplina(DisciplinaModel disciplinaModel) {
        return disciplinaRepository.save(disciplinaModel);
    }

    public List<DisciplinaModel> getAllDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Optional<DisciplinaModel> getDisciplinaId(int disciplinaId) {
        return disciplinaRepository.findById(disciplinaId);
    }

    public void deleteDisciplina(int disciplinaId) {
        disciplinaRepository.deleteById(disciplinaId);
    }
}

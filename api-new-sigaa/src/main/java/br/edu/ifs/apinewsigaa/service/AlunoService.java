package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.model.AlunoModel;
import br.edu.ifs.apinewsigaa.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoModel saveAluno(AlunoModel alunoModel) {
        return alunoRepository.save(alunoModel);
    }


    public List<AlunoModel> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<AlunoModel> getAlunoId(int alunoID) {
        return alunoRepository.findById(alunoID);
    }

    public void deleteAluno(int alunoModel) {
        alunoRepository.deleteById(alunoModel);
    }
}

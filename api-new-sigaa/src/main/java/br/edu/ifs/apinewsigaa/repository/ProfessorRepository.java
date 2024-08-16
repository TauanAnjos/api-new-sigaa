package br.edu.ifs.apinewsigaa.repository;

import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, Integer> {

    Optional<ProfessorModel> findByCpf(String cpf);
    Optional<ProfessorModel> findByNome(String nome);

    Optional<ProfessorModel> findByEmail(String email);
    Optional<ProfessorModel> findByMatricula(String matricula);

    void deleteByMatricula(String matricula);


}

package br.edu.ifs.apinewsigaa.repository;

import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, Integer> {

    Optional<ProfessorModel> findByCpf(String cpf);
    Optional<ProfessorModel> findByNome(String nome);

    Optional<ProfessorModel> findByEmail(String email);
    Optional<ProfessorModel> findByMatricula(int matricula);
}

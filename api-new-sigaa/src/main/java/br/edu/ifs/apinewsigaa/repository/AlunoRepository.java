package br.edu.ifs.apinewsigaa.repository;

import br.edu.ifs.apinewsigaa.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Integer> {

    Optional<AlunoModel> findByMatricula(String matricula);
    Optional<AlunoModel> findByNome(String nome);
    Optional<AlunoModel> findByCpf(String cpf);
    Optional<AlunoModel> findByEmail(String email);
    Optional<AlunoModel> findByCelular(String celular);
    void deleteByMatricula(String matricula);
    void deleteByCpf(String cpf);
    void deleteByEmail(String email);
    void deleteByCelular(String celular);
    void deleteByNome(String nome);
    boolean existsByMatricula(String matricula);
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsByCelular(String celular);
    boolean existsByNome(String nome);
    List<AlunoModel> findByNomeContaining(String nome);

    List<AlunoModel> findByOrderByNomeDesc();

    @Query(value = "SELECT * FROM aluno a " + "WHERE a.email = :email", nativeQuery = true)
    List<AlunoModel> ObterAlunoPorEmail(@Param("email") String email);

}

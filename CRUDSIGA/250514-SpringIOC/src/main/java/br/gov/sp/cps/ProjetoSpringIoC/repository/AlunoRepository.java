package br.gov.sp.cps.ProjetoSpringIoC.repository;

import br.gov.sp.cps.ProjetoSpringIoC.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByUsuarioAndPassword(String usuario, String password);

}

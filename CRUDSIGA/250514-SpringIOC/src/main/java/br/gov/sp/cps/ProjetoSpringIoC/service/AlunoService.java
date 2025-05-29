package br.gov.sp.cps.ProjetoSpringIoC.service;

import br.gov.sp.cps.ProjetoSpringIoC.entity.Aluno;
import br.gov.sp.cps.ProjetoSpringIoC.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Aluno buscarPorId(Long id){
        return alunoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario não encontrado...")
        );
    }

    public List<Aluno> listarTodos(){
        return alunoRepository.findAll();
    }

    public Aluno editarSenha(Long id, String novaSenha){
        Aluno aluno = buscarPorId(id);
        aluno.setPassword(novaSenha);
        return alunoRepository.save(aluno);
    }

    public Aluno buscarPorUsuarioESenha(String usuario, String password) {
        return alunoRepository.findByUsuarioAndPassword(usuario, password)
                .orElseThrow(() -> new RuntimeException("Usuário ou senha inválidos"));
    }


    public void deletarPorId(Long id){
        alunoRepository.deleteById(id);
    }

    public void deletarTodos(){
        alunoRepository.deleteAll();
    }
}

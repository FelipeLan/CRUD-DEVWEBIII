package br.gov.sp.cps.ProjetoSpringIoC.controller;

import br.gov.sp.cps.ProjetoSpringIoC.entity.Aluno;
import br.gov.sp.cps.ProjetoSpringIoC.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4000")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuarios")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno){
        Aluno user = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id){
        Aluno user = alunoService.buscarPorId(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        List<Aluno> users = alunoService.listarTodos();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        Aluno existente = alunoService.buscarPorId(id);
        existente.setNome(alunoAtualizado.getNome());
        existente.setEmail(alunoAtualizado.getEmail());
        existente.setPassword(alunoAtualizado.getPassword());
        existente.setTelefone(alunoAtualizado.getTelefone());
        existente.setCurso(alunoAtualizado.getCurso());
        existente.setDisciplina(alunoAtualizado.getDisciplina());
        existente.setStatus(alunoAtualizado.getStatus());
        existente.setNota1(alunoAtualizado.getNota1());
        existente.setNota2(alunoAtualizado.getNota2());
        Aluno atualizado = alunoService.salvar(existente);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        alunoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    };

    @DeleteMapping("/deletartodos")
    public ResponseEntity<Void> deleteAll(){
        alunoService.deletarTodos();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/login")
    public ResponseEntity<Aluno> login(@RequestParam String usuario, @RequestParam String password) {
        Aluno aluno = alunoService.buscarPorUsuarioESenha(usuario, password);
        return ResponseEntity.ok(aluno);
    }
}

package br.gov.sp.cps.ProjetoSpringIoC.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="cadastro")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "usuario")
    private String usuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column (name = "curso")
    private String curso;

    @Column(name = "status")
    private String status;

    @Column(name = "telefone")
    private String telefone;

    @Column (name = "disciplina")
    private String disciplina;

    @Column(name = "nota1")
    private double nota1;

    @Column(name = "nota2")
    private double nota2;

    @Column (name = "media")
    private double media;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public double getNota1() {
        return nota1;
    }
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
    public double getMedia() {
        return media;
    }

    @PrePersist
    @PreUpdate
    public void calcularMedia() {
        this.media = (nota1 + nota2) / 2.0;
    }
}

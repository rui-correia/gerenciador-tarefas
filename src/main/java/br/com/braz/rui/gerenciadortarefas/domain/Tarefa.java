package br.com.braz.rui.gerenciadortarefas.domain;

import br.com.braz.rui.gerenciadortarefas.dto.TarefaResponse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String titulo;
    @NotBlank
    private String descricao;
    @NotNull(message = "Data invalida.")
    private LocalDate dataCadastro;

    @Deprecated
    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, LocalDate dataCadastro) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public TarefaResponse toResponse(){
        return new TarefaResponse(this.id, this.titulo);
    }

}

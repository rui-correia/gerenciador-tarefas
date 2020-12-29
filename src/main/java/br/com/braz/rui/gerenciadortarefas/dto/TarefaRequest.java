package br.com.braz.rui.gerenciadortarefas.dto;

import br.com.braz.rui.gerenciadortarefas.domain.Tarefa;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TarefaRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotNull(message = "Data invalida.")
    private LocalDate dataCadastro;

    public Tarefa toModel(){
        return new Tarefa(this.titulo, this.descricao, this.dataCadastro);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}

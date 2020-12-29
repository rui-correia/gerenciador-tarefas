package br.com.braz.rui.gerenciadortarefas.service;

import br.com.braz.rui.gerenciadortarefas.domain.Tarefa;
import br.com.braz.rui.gerenciadortarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    //CriarTarefa
    public Tarefa cadastrar(Tarefa tarefa) throws Exception {

        if (existeTitulo(tarefa.getTitulo()) == true) { //Verifica se existe alguma tarefa com esse titulo
            throw new Exception("Titulo ja cadastrado");
        }else {
            return tarefaRepository.save(tarefa);
        }
    }

    public boolean existeTitulo(String titulo) {
        return tarefaRepository.findByTitulo(titulo) != null;
    }

    //BuscarTarefa
    public Tarefa buscar(Long id) {
        return tarefaRepository.findById(id).get();
    }


    //AtualizarTarefa
    //DeletarTarefa
}

package br.com.braz.rui.gerenciadortarefas.contoller;

import br.com.braz.rui.gerenciadortarefas.domain.Tarefa;
import br.com.braz.rui.gerenciadortarefas.dto.TarefaRequest;
import br.com.braz.rui.gerenciadortarefas.dto.TarefaResponse;
import br.com.braz.rui.gerenciadortarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tarefa")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    //CriaTarefa
    @PostMapping
    public ResponseEntity<TarefaResponse> cadastrar(@RequestBody TarefaRequest tarefaRequest) throws Exception {

        Tarefa tarefa = tarefaRequest.toModel();
        tarefaService.cadastrar(tarefa);
        TarefaResponse tarefaResponse = tarefa.toResponse();

        return ResponseEntity.status(HttpStatus.OK).body(tarefaResponse);
    }

    //BuscaTarefa
    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponse> buscar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.buscar(id).toResponse());
    }
    //AtualizaTarefa

    //DeletaTarefa


}

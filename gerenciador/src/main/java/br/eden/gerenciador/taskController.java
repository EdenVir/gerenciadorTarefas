package br.eden.gerenciador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class taskController {

    @Autowired
    private repositorioTarefas repositorioTarefas;

    @GetMapping
    public List<Tarefa> getAllTarefa(){
        return repositorioTarefas.findAll();
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa ){
        return  repositorioTarefas.save(tarefa);
    }

    @PutMapping
    public Tarefa atualizarTarefa(@PathVariable long id, @RequestBody Tarefa detalheTarefa){
        Tarefa tarefa =repositorioTarefas.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada por esse id: " + id));

        tarefa.setTitulo(detalheTarefa.getTitulo());
        tarefa.setDescricao(detalheTarefa.getDescricao());

        return repositorioTarefas.save(tarefa);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable long id){
        repositorioTarefas.deleteById(id);
        return ResponseEntity.ok().build();
    }


}


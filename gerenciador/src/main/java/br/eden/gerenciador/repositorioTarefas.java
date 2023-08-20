package br.eden.gerenciador;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface repositorioTarefas extends JpaRepository<Tarefa, Long> {


}

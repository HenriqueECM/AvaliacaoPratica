package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Prioridade;
import utils.Validador;
import patterns.creation.TarefaFactory;

import model.Tarefa;

public class TarefaController {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void criarTarefa(String titulo, String descricao, Prioridade prioridade, LocalDate prazo){
        if (Validador.validarTitulo(titulo) && Validador.validarData(prazo)){
            Tarefa tarefa = TarefaFactory.criarTarefa(titulo, descricao, prioridade, prazo);
            tarefas.add(tarefa);
            System.out.println("Tarefa criada com sucesso!");
        } else {
            System.out.println("Dados inválidos!");
        }
    }

    public List<Tarefa> listaTarefas(){
        return tarefas;
    }

    public void marcarConcluida(int index){
        if (index >= 0 && index < tarefas.size()){
            tarefas.get(index).setConcluida(true);
            System.out.println("Tarefa marcada como concluída.");
        } else {
            System.out.println("Inválido.");
        }
    }

    public List<Tarefa> listaVencidas(){
        List<Tarefa> vencidas = new ArrayList<>();
        for (Tarefa t : tarefas){
            if (t.getPrazo().isBefore(LocalDate.now()) && !t.isConcluida()) {
                vencidas.add(t);
            }
        }
        return vencidas;
    }

    public List<Tarefa> filtrarPrioriTarefas(Prioridade prioridade){
        List<Tarefa> filtradas = new ArrayList<>();
        for (Tarefa t : tarefas){
            if (t.getPrioridade() == prioridade) {
                filtradas.add(t);
            }
        }
        return filtradas;
    }
}

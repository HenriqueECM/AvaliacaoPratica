package view;

import controller.TarefaController;
import model.Prioridade;
import model.Tarefa;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TarefaView {
    private TarefaController controller;
    private Scanner sc = new Scanner(System.in);

    public TarefaView(TarefaController controller) {
        this.controller = controller;
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println(
                    "\n1. Criar Tarefa\n2. Listar Todas\n3. Marcar como Concluída\n4. Listar Vencidas\n5. Filtrar por Prioridade\n0. Sair");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    criarTarefa();
                case 2: 
                    listar(controller.listaTarefas());
                case 3:
                    marcarConcluida();
                case 4: 
                    listar(controller.listaVencidas());
                case 5: 
                    filtrarPorPrioridade();
            }
        } while (opcao != 0);
    }

    private void criarTarefa() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Descrição: ");
        String desc = sc.nextLine();
        System.out.print("Prioridade (BAIXA/MEDIA/ALTA): ");
        Prioridade prioridade = Prioridade.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Prazo (YYYY-MM-DD): ");
        LocalDate prazo = LocalDate.parse(sc.nextLine());
        controller.criarTarefa(titulo, desc, prioridade, prazo);
    }

    private void listar(List<Tarefa> tarefas) {
        int i = 0;
        for (Tarefa t : tarefas) {
            System.out.printf("%d - %s\n", i++, t);
        }
    }

    private void marcarConcluida() {
        listar(controller.listaTarefas());
        System.out.print("Digite o índice da tarefa: ");
        int i = Integer.parseInt(sc.nextLine());
        controller.marcarConcluida(i);
    }

    private void filtrarPorPrioridade() {
        System.out.print("Prioridade (BAIXA/MEDIA/ALTA): ");
        Prioridade prioridade = Prioridade.valueOf(sc.nextLine().toUpperCase());
        listar(controller.filtrarPrioriTarefas(prioridade));
    }

}
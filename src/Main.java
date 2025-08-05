import controller.TarefaController;
import model.Prioridade;
import patterns.behavioral.FiltroPrioridadeStrategy;

import view.TarefaView;

import java.time.LocalDate;

public class Main {
    
    public static void main(String[] args) {
        TarefaController controller = new TarefaController();
        TarefaView view = new TarefaView(controller);
        view.exibirMenu();
    }
}

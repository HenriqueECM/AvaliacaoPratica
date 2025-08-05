// Strategy

package patterns.behavioral;

import model.Tarefa;
import model.Prioridade;
import java.util.List;

public interface FiltroPrioridadeStrategy {
    List<Tarefa> filtrar(List<Tarefa> tarefas);
}

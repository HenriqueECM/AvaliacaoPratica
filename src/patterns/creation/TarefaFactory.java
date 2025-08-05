// Factory

package patterns.creation;

import model.Tarefa;
import model.Prioridade;
import java.time.LocalDate;

public class TarefaFactory {
    public static Tarefa criarTarefa(String titulo, String descricao, Prioridade prioridade, LocalDate prazo){
        return new Tarefa(titulo, descricao, prioridade, prazo);
    }
}

package patterns.behavioral;

import java.util.ArrayList;
import java.util.List;
import model.Prioridade;
import model.Tarefa;

public class FiltroPrioridadeAlta implements FiltroPrioridadeStrategy {
    
    @Override

    public List<Tarefa> filtrar(List<Tarefa> tarefas){
        List<Tarefa> resultado = new ArrayList<>();
        for (Tarefa t : tarefas){
            if (t.getPrioridade() == Prioridade.ALTA){
                resultado.add(t);
            }
        }
        return resultado;
    }
}

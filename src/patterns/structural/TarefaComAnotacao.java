// Decorator

package patterns.structural;

import model.Tarefa;

public class TarefaComAnotacao extends Tarefa {

    private String anotacao;

    public TarefaComAnotacao(Tarefa base, String anotacao) {
        super(base.getTitulo(), base.getDescricao(), base.getPrioridade(), base.getPrazo());
        this.anotacao = anotacao;
    }

    @Override
    public String toString() {
        return super.toString() + " | Anotação: " + anotacao;
    }
}
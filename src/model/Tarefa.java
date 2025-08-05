package model;

import java.time.LocalDate;

public class Tarefa{
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private LocalDate prazo;
    private boolean concluida;


    public Tarefa(String titulo, String descricao, Prioridade prioridade, LocalDate prazo){
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.prazo = prazo;
        this.concluida = false;
    }

    public String getTitulo(){return titulo;}
    public String getDescricao(){return descricao;}
    public Prioridade getPrioridade(){return prioridade;}
    public LocalDate getPrazo(){return prazo;}
    public boolean isConcluida(){return concluida;}


    public void setConcluida(boolean concluida){
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (Prioridade: %s | Prazo: %s)%s",
                concluida ? "X" : " ",
                titulo,
                prioridade,
                prazo,
                prazo.isBefore(LocalDate.now()) && !concluida ? " [VENCIDA]" : "");
    }

}
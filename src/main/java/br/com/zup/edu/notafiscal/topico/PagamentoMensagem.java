package br.com.zup.edu.notafiscal.topico;


import java.util.UUID;

public class PagamentoMensagem {

    private UUID id;

    private Forma forma;

    private Status status;

    public PagamentoMensagem() {
    }

    public PagamentoMensagem(UUID id, Forma forma, Status status) {
        this.id = id;
        this.forma = forma;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public Forma getForma() {
        return forma;
    }

    public Status getStatus() {
        return status;
    }

}

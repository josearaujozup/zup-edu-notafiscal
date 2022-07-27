package br.com.zup.edu.notafiscal.email;

import br.com.zup.edu.notafiscal.nota.ItemNota;

import java.math.BigDecimal;

public class EmailItemNotaResponse {

    private String nome;

    private Integer quantidade;

    private BigDecimal valor;

    public EmailItemNotaResponse(){

    }

    public EmailItemNotaResponse(String nome, Integer quantidade, BigDecimal valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public EmailItemNotaResponse(ItemNota itemNota) {
        this.nome = itemNota.getNome();
        this.quantidade = itemNota.getQuantidade();
        this.valor = itemNota.getValor();
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }
}

package br.com.zup.edu.notafiscal.email;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class EmailNotaFiscalResponse {

    private Long numeroDaNota;

    private LocalDateTime criadoEm;

    private String nomeComprador;

    private String cpf;

    private String endereco;

    private List<EmailItemNotaResponse> itens;

    private BigDecimal valorTotal;

    public EmailNotaFiscalResponse(){

    }

    public EmailNotaFiscalResponse(Long numeroDaNota, LocalDateTime criadoEm, String nomeComprador, String cpf, String endereco, List<EmailItemNotaResponse> itens, BigDecimal valorTotal) {
        this.numeroDaNota = numeroDaNota;
        this.criadoEm = criadoEm;
        this.nomeComprador = nomeComprador;
        this.cpf = cpf;
        this.endereco = endereco;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

    public Long getNumeroDaNota() {
        return numeroDaNota;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<EmailItemNotaResponse> getItens() {
        return itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }
}

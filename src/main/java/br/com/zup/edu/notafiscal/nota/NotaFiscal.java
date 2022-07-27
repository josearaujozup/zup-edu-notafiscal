package br.com.zup.edu.notafiscal.nota;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime criadoEm = LocalDateTime.now();

    private String nomeComprador;

    private String cpf;

    private String endereco;

    @OneToMany(cascade = {CascadeType.PERSIST})
    private List<ItemNota> itens = new ArrayList<>();

    private BigDecimal valorTotal;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusNota status = StatusNota.GERADA;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public NotaFiscal() {
    }

    public NotaFiscal(String nomeComprador, String cpf, String endereco, List<ItemNota> itens, BigDecimal valorTotal) {
        this.nomeComprador = nomeComprador;
        this.cpf = cpf;
        this.endereco = endereco;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
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

    public List<ItemNota> getItens() {
        return itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public StatusNota getStatus() {
        return status;
    }
}

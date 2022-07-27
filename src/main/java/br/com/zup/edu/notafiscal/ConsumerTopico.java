package br.com.zup.edu.notafiscal;

import br.com.zup.edu.notafiscal.email.EmailServiceImpl;
import br.com.zup.edu.notafiscal.nota.ItemNota;
import br.com.zup.edu.notafiscal.nota.NotaFiscal;
import br.com.zup.edu.notafiscal.nota.NotaFiscalRepository;
import br.com.zup.edu.notafiscal.topico.Mensagem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConsumerTopico {

    @Autowired
    private ObjectMapper mapper;

    private final NotaFiscalRepository notaFiscalRepository;

    public ConsumerTopico(NotaFiscalRepository notaFiscalRepository) {
        this.notaFiscalRepository = notaFiscalRepository;
    }

    @KafkaListener(topics = "teste")
    public void receber(String mensagem) throws JsonProcessingException {
        System.out.println("Recebeu: " + mensagem);

        Mensagem result = mapper.readValue(mensagem, Mensagem.class);


        List<ItemNota> itensNota = new ArrayList<>();

        result.getItens().forEach(i -> {
            itensNota.add(new ItemNota(i));
        });

        BigDecimal valorTotal = itensNota.stream().map(i -> i.getValor().multiply(BigDecimal.valueOf(i.getQuantidade()))).reduce(BigDecimal.ZERO, BigDecimal::add);

        NotaFiscal notaFiscal = new NotaFiscal(
                result.getComprador().getNome(),
                result.getComprador().getCpf(),
                result.getComprador().getEndereco(),
                result.getComprador().getEmail(),
                itensNota,
                valorTotal);

        notaFiscalRepository.save(notaFiscal);

    }

}

package br.com.zup.edu.notafiscal.email;

import br.com.zup.edu.notafiscal.nota.NotaFiscal;
import br.com.zup.edu.notafiscal.nota.NotaFiscalRepository;
import br.com.zup.edu.notafiscal.nota.StatusNota;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnviaEmail {

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Scheduled(fixedDelay = 3000)
    @Transactional
    public void enviar() throws JsonProcessingException{

        List<NotaFiscal> notasFiscais = notaFiscalRepository.findTop3ByStatusOrderByCriadoEmAsc(StatusNota.GERADA);

        notasFiscais.forEach(n -> {

            EmailNotaFiscalResponse emailNotaFiscalResponse = new EmailNotaFiscalResponse(
                    n.getId(),
                    n.getCriadoEm(),
                    n.getNomeComprador(),
                    n.getCpf(),
                    n.getEndereco(),
                    n.getItens().stream().map(EmailItemNotaResponse::new).collect(Collectors.toList()),
                    n.getValorTotal());

            try {
                String emailPayload = mapper.writeValueAsString(emailNotaFiscalResponse);
                emailService.sendEmail(n.getEmail(),emailPayload);
                n.mudarStatus(StatusNota.GERADA_E_ENVIADA);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        });

    }

}

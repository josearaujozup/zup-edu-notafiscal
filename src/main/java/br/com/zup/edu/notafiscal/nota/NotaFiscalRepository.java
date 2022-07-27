package br.com.zup.edu.notafiscal.nota;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal,Long> {
    List<NotaFiscal> findTop3ByStatusOrderByCriadoEmAsc(StatusNota status);
}

package br.com.movimentosmanuais.repository.movimento;

import br.com.movimentosmanuais.domain.movimento.MovimentoManual;
import br.com.movimentosmanuais.domain.movimento.MovimentoManualId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoManualRepository extends JpaRepository<MovimentoManual, MovimentoManualId> {
}

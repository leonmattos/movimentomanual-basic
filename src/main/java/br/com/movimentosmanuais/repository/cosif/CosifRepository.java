package br.com.movimentosmanuais.repository.cosif;

import br.com.movimentosmanuais.domain.cosif.Cosif;
import br.com.movimentosmanuais.domain.cosif.CosifId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CosifRepository extends JpaRepository<Cosif, CosifId> {
}

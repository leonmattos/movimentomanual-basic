package br.com.movimentosmanuais.service.cosif;

import br.com.movimentosmanuais.domain.cosif.Cosif;
import br.com.movimentosmanuais.repository.cosif.CosifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CosifService {
    @Autowired
    private CosifRepository cosifRepository;

    public List<Cosif> findAll() {
        return cosifRepository.findAll();
    }

    public Cosif save(Cosif cosif) {
        return cosifRepository.save(cosif);
    }
}

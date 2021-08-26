package br.com.movimentosmanuais.service.movimentomanual;

import br.com.movimentosmanuais.domain.movimento.MovimentoManual;
import br.com.movimentosmanuais.repository.movimento.MovimentoManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentoManualService {
    @Autowired
    private MovimentoManualRepository movimentoManualRepository;

    public List<MovimentoManual> findAll() {
        return movimentoManualRepository.findAll();
    }

    public MovimentoManual save(MovimentoManual movimentoManual) {
        return movimentoManualRepository.save(movimentoManual);
    }
}

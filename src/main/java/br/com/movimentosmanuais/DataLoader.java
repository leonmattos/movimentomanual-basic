package br.com.movimentosmanuais;

import br.com.movimentosmanuais.domain.cosif.Cosif;
import br.com.movimentosmanuais.domain.cosif.CosifId;
import br.com.movimentosmanuais.domain.movimento.MovimentoManual;
import br.com.movimentosmanuais.domain.movimento.MovimentoManualId;
import br.com.movimentosmanuais.domain.produto.Produto;
import br.com.movimentosmanuais.repository.cosif.CosifRepository;
import br.com.movimentosmanuais.repository.movimento.MovimentoManualRepository;
import br.com.movimentosmanuais.repository.produto.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ProdutoRepository userRepository;

    @Autowired
    private CosifRepository cosifRepository;

    @Autowired
    private MovimentoManualRepository movimentoManualRepository;

    public void run(ApplicationArguments args) {
        log.info("Inserindo dados");
        Produto garfo = new Produto("001", "Garfo", "1");
        userRepository.save(garfo);
        userRepository.save(new Produto("002", "Colher", "1"));
        userRepository.save(new Produto("003", "Faca", "1"));

        Cosif cosif = new Cosif(new CosifId(garfo, "001"), "000001", "0");
        cosifRepository.save(cosif);

        MovimentoManual movimentoManual = new MovimentoManual();
        MovimentoManualId movimentoManualId = new MovimentoManualId(02, 2021, 1, cosif);
        movimentoManual.setMovimentoManualId(movimentoManualId);
        movimentoManual.setDataMovimento(new Date());
        movimentoManual.setCodUsuario("TESTE");
        movimentoManual.setDescricao("DESCRIÇÃO DO MOVIMENTO");
        movimentoManual.setValValor(BigDecimal.TEN);
        movimentoManualRepository.save(movimentoManual);
    }
}

package br.com.movimentosmanuais.repositoty;

import br.com.movimentosmanuais.BaseTest;
import br.com.movimentosmanuais.domain.cosif.Cosif;
import br.com.movimentosmanuais.domain.cosif.CosifId;
import br.com.movimentosmanuais.domain.movimento.MovimentoManual;
import br.com.movimentosmanuais.domain.movimento.MovimentoManualId;
import br.com.movimentosmanuais.domain.produto.Produto;
import br.com.movimentosmanuais.repository.cosif.CosifRepository;
import br.com.movimentosmanuais.repository.movimento.MovimentoManualRepository;
import br.com.movimentosmanuais.repository.produto.ProdutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class MovimentoManualRepositoryTest extends BaseTest {
    @Autowired
    private MovimentoManualRepository movimentoManualRepository;

    @Autowired
    private ProdutoRepository userRepository;

    @Autowired
    private CosifRepository cosifRepository;


    private Resource resource;

    @Before
    public void setUp(){
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

    @Test
    public void saveMovimentoManual(){
        MovimentoManual movimentoManual = carregaDadosViaJson(new MovimentoManual(), "movimentomanual");
        MovimentoManual saved = movimentoManualRepository.save(movimentoManual);
        List<MovimentoManual> all = this.movimentoManualRepository.findAll();
        Assert.assertNotNull(saved);
        Assert.assertEquals(2, all.size());
    }


    @Test
    public void existeDadosPersistidos() {
        List<MovimentoManual> all = this.movimentoManualRepository.findAll();
        Assert.assertEquals(1, all.size());
    }
}

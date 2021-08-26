package br.com.movimentosmanuais.domain.movimento;

import br.com.movimentosmanuais.domain.cosif.Cosif;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentoManualId implements Serializable {
    @Column(name = "DT_MES", precision = 2)
    private Integer mes;

    @Column(name = "DT_ANO", precision = 4)
    private Integer ano;

    @Column(name = "NUM_LANCAMENTO", precision = 18)
    private Integer numeroLancamento;

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUTO"),
            @JoinColumn(name = "COD_COSIF", referencedColumnName = "COD_COSIF")
    }, foreignKey = @ForeignKey(name = "FK_MOVIMENTO_COSIF_PRODUTO"))
    private Cosif cosif;
}

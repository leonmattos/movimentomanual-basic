package br.com.movimentosmanuais.domain.cosif;

import br.com.movimentosmanuais.domain.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CosifId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO", foreignKey = @ForeignKey(name = "FK_COSIF_PRODUTO"))
    private Produto produto;

    @Column(name = "COD_COSIF", length = 11)
    private String codCosif;
}

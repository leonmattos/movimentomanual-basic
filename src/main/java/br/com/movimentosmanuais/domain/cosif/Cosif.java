package br.com.movimentosmanuais.domain.cosif;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUTO_COSIF")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cosif implements Serializable {
    @EmbeddedId
    private CosifId cosifId;
    @Column(name = "COD_CLASSIFICACAO", length = 6)
    private String codClassificacao;
    @Column(name = "STA_STATUS", length = 1)
    private String staStatus;

}

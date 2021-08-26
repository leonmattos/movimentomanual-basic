package br.com.movimentosmanuais.domain.movimento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MOVIMENTO_MANUAL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentoManual implements Serializable {
    @EmbeddedId
    private MovimentoManualId movimentoManualId;

    @Column(name = "DES_DESCRICAO", length = 50, nullable = false)
    private String descricao;

    @Column(name = "DAT_MOVIMENTO", length = 50, nullable = false)
    private Date dataMovimento;

    @Column(name = "COD_USUARIO", length = 15, nullable = false)
    private String codUsuario;

    @Column(name = "VAL_VALOR", scale = 2, precision = 18, nullable = false)
    private BigDecimal valValor;


}

package br.com.movimentosmanuais.domain.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "PRODUTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto implements Serializable {

    @Id
    @Column(name = "COD_PRODUTO", length = 4, nullable = false)
    private String codProduto;

    @Column(name = "DES_PRODUTO", length = 30)
    private String descricao;

    @Column(name = "STA_STATUS", length = 1)
    private String status;
}

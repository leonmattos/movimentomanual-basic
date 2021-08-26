package br.com.movimentosmanuais.dto.cosif;

import br.com.movimentosmanuais.domain.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CosifIdDTO {
    private Produto produto;
    private String codCosif;
}

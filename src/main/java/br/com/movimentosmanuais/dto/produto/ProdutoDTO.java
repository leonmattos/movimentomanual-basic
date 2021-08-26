package br.com.movimentosmanuais.dto.produto;

import br.com.movimentosmanuais.domain.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    @NotNull(message = "{notempty}")
    private String descricao;
    private String status;

    public Produto toEntity(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        return produto;
    }
}

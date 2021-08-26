package br.com.movimentosmanuais.dto.cosif;


import br.com.movimentosmanuais.domain.cosif.Cosif;
import br.com.movimentosmanuais.domain.cosif.CosifId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CosifDTO {
    private CosifId cosifId;
    private String codClassificacao;
    private String staStatus;

    public static Cosif toEntity(CosifDTO cosifDTO) {
        Cosif cosif = new Cosif();
        BeanUtils.copyProperties(cosifDTO, cosif);
        return cosif;
    }
}

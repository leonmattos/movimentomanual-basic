package br.com.movimentosmanuais.dto.movimento;


import br.com.movimentosmanuais.domain.movimento.MovimentoManualId;
import br.com.movimentosmanuais.dto.cosif.CosifDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentoManualIdDTO implements Serializable {

    @Min(1)
    @Max(12)
    @NotNull
    private Integer mes;

    @Min(1000)
    private Integer ano;

    @Min(1)
    private Integer numeroLancamento;

    @Valid
    private CosifDTO cosif;

    public static MovimentoManualId toEntity(MovimentoManualIdDTO movimentoManualIdDTO) {
        MovimentoManualId movimentoManualId = new MovimentoManualId();
        BeanUtils.copyProperties(movimentoManualIdDTO, movimentoManualId);
        movimentoManualId.setCosif(CosifDTO.toEntity(movimentoManualIdDTO.getCosif()));
        return movimentoManualId;
    }
}

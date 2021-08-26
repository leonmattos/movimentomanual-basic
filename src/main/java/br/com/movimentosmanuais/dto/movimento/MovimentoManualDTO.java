package br.com.movimentosmanuais.dto.movimento;

import br.com.movimentosmanuais.domain.cosif.Cosif;
import br.com.movimentosmanuais.domain.movimento.MovimentoManual;
import br.com.movimentosmanuais.domain.movimento.MovimentoManualId;
import br.com.movimentosmanuais.dto.cosif.CosifDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimentoManualDTO {
    @Valid
    private MovimentoManualIdDTO movimentoManualId;

    private String descricao;

    private LocalDate dataMovimento;

    private String codUsuario;

    private BigDecimal valValor;


    public static MovimentoManual toEntity(MovimentoManualDTO movimentoManualDTO) {
        MovimentoManual movimentoManual = new MovimentoManual();
        BeanUtils.copyProperties(movimentoManualDTO, movimentoManual);
        movimentoManual.setMovimentoManualId(MovimentoManualIdDTO.toEntity(movimentoManualDTO.getMovimentoManualId()));
        return movimentoManual;
    }

}

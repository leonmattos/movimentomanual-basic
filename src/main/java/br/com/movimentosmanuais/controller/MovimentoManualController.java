package br.com.movimentosmanuais.controller;

import br.com.movimentosmanuais.domain.movimento.MovimentoManual;
import br.com.movimentosmanuais.dto.movimento.MovimentoManualDTO;
import br.com.movimentosmanuais.service.movimentomanual.MovimentoManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/movimento")
public class MovimentoManualController {
    @Autowired
    private MovimentoManualService movimentoManualService;

    @GetMapping
    public List<MovimentoManual> findAll(){
        return movimentoManualService.findAll();
    }

    @PostMapping
    public ResponseEntity<MovimentoManual> save(@Valid @RequestBody MovimentoManualDTO movimentoManualDTO) {
        MovimentoManual savedMovimento = movimentoManualService.save(MovimentoManualDTO.toEntity(movimentoManualDTO));
        return ResponseEntity.ok(savedMovimento);
    }
}

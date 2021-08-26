package br.com.movimentosmanuais.controller;

import br.com.movimentosmanuais.domain.cosif.Cosif;
import br.com.movimentosmanuais.service.cosif.CosifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cosif")
public class CosifController {
    @Autowired
    private CosifService cosifService;

    @GetMapping
    public List<Cosif> findAll(){
        return cosifService.findAll();
    }

    @PostMapping
    public ResponseEntity<Cosif> save(@RequestBody Cosif cosif) {
        Cosif savedCosif = cosifService.save(cosif);
        return ResponseEntity.ok(savedCosif);
    }
}

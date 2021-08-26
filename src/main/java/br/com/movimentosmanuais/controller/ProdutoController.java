package br.com.movimentosmanuais.controller;

import br.com.movimentosmanuais.domain.produto.Produto;
import br.com.movimentosmanuais.dto.produto.ProdutoDTO;
import br.com.movimentosmanuais.service.produto.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Page<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/pageable")
    public Page<Produto> findAllPageable(Pageable pageable) {
        return produtoService.findAllPageable(pageable);
    }


    @GetMapping("/search")
    public Page<Produto> search(@RequestParam("searchTerm") String searchTerm,
                                Pageable pageable) {

        return produtoService.search(searchTerm, pageable);
    }



    @ApiOperation(value = "Salva um produto", notes = "Este endpoint persite um novo produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto salvo"),
            @ApiResponse(code = 403, message = "Sem permissão"),
            @ApiResponse(code = 500, message = "Falha no servidor"),
    })
    @PostMapping
    public ResponseEntity<ProdutoDTO> save(@Valid @RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(produtoDTO);
    }
}

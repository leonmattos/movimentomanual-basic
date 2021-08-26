package br.com.movimentosmanuais.service.produto;

import br.com.movimentosmanuais.domain.produto.Produto;
import br.com.movimentosmanuais.repository.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Page<Produto> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Produto> search(String searchTerm, Pageable pageable) {
        return repository.search(searchTerm.toLowerCase(), pageable);
    }

    public Page<Produto> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "name");
        return new PageImpl<>(
                repository.findAll(),
                pageRequest, size);
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }
}

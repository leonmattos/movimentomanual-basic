package br.com.movimentosmanuais.repository.produto;

import br.com.movimentosmanuais.domain.produto.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


import java.util.Collection;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("FROM Produto p " +
            "WHERE LOWER(p.descricao) like %:searchTerm% " +
            "OR LOWER(p.status) like %:searchTerm%")
    Page<Produto> search(@Param("searchTerm") String searchTerm, Pageable pageable);

}

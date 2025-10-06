package br.com.artnomic.main.domain;

import br.com.artnomic.main.anotacao.ColunaTabela;
import br.com.artnomic.main.anotacao.Tabela;
import br.com.artnomic.main.dao.Persistente;

@Tabela("TB_ESTOQUE")
public class Estoque implements Persistente {

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    private Produto produto;

    @ColunaTabela(dbName = "id_produto_fk", setJavaName = "setIdProdutoFk")
    private Long idProdutoFk;

    @ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
    private Integer quantidade;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getIdProdutoFk() {
        if (this.produto != null) {
            return this.produto.getId();
        }
        return idProdutoFk;
    }

    public void setIdProdutoFk(Long idProdutoFk) {
        this.idProdutoFk = idProdutoFk;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

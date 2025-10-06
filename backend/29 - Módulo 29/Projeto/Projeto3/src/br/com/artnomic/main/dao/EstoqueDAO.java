package br.com.artnomic.main.dao;

import br.com.artnomic.main.dao.generic.GenericDAO;
import br.com.artnomic.main.domain.Estoque;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstoqueDAO extends GenericDAO<Estoque, Long> implements IEstoqueDAO {

    public EstoqueDAO() {
        super();
    }

    @Override
    public Class<Estoque> getTipoClasse() {
        return Estoque.class;
    }

    @Override
    public void atualiarDados(Estoque entity, Estoque entityCadastrado) {
        entityCadastrado.setQuantidade(entity.getQuantidade());
        entityCadastrado.setProduto(entity.getProduto());
        entityCadastrado.setIdProdutoFk(entity.getIdProdutoFk());
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO TB_ESTOQUE (ID, ID_PRODUTO_FK, QUANTIDADE) VALUES (nextval('sq_estoque'), ?, ?)";
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_ESTOQUE WHERE ID = ?";
    }

    @Override
    protected String getQueryAtualizacao() {
        return "UPDATE TB_ESTOQUE SET QUANTIDADE = ? WHERE ID_PRODUTO_FK = ?";
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        stmInsert.setLong(1, entity.getIdProdutoFk());
        stmInsert.setInt(2, entity.getQuantidade());
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, Long valor) throws SQLException {
        stmDelete.setLong(1, valor);
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
        stmUpdate.setInt(1, entity.getQuantidade());
        stmUpdate.setLong(2, entity.getIdProdutoFk());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
        stmSelect.setLong(1, valor);
    }
}
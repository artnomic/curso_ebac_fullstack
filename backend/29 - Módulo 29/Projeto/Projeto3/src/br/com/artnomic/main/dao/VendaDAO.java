package br.com.artnomic.main.dao;

import br.com.artnomic.main.dao.factory.ProdutoQuantidadeFactory;
import br.com.artnomic.main.dao.factory.VendaFactory;
import br.com.artnomic.main.dao.generic.GenericDAO;
import br.com.artnomic.main.domain.ProdutoQuantidade;
import br.com.artnomic.main.domain.Venda;
import br.com.artnomic.main.exceptions.DAOException;
import br.com.artnomic.main.exceptions.MaisDeUmRegistroException;
import br.com.artnomic.main.exceptions.TableException;
import br.com.artnomic.main.exceptions.TipoChaveNaoEncontradaException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO {

    @Override
    public void limparTabelas() throws DAOException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = getConnection();

            stm = connection.prepareStatement("DELETE FROM TB_PRODUTO_QUANTIDADE");
            stm.executeUpdate();
            stm.close();

            stm = connection.prepareStatement("DELETE FROM TB_VENDA");
            stm.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("ERRO LIMPANDO TABELAS DE VENDA", e);
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Class<Venda> getTipoClasse() {
        return Venda.class;
    }

    @Override
    public void atualiarDados(Venda entity, Venda entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setStatus(entity.getStatus());
    }

    @Override
    public void excluir(String valor) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public void finalizarVenda(Venda venda) throws DAOException {

        Connection connection = null;
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE TB_VENDA SET STATUS_VENDA = ? WHERE ID = ?";
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, Venda.Status.CONCLUIDA.name());
            stm.setLong(2, venda.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("ERRO ATUALIZANDO OBJETO ", e);
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public void cancelarVenda(Venda venda) throws DAOException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE TB_VENDA SET STATUS_VENDA = ? WHERE ID = ?";
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, Venda.Status.CANCELADA.name());
            stm.setLong(2, venda.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("ERRO ATUALIZANDO OBJETO ", e);
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO TB_VENDA " +
                "(ID, CODIGO, ID_CLIENTE_FK, VALOR_TOTAL, DATA_VENDA, STATUS_VENDA)" +
                "VALUES (nextval('sq_venda'),?,?,?,?,?)";
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Venda entity) throws SQLException {
        stmInsert.setString(1, entity.getCodigo());
        stmInsert.setLong(2, entity.getCliente().getId());
        stmInsert.setBigDecimal(3, entity.getValorTotal());
        stmInsert.setTimestamp(4, Timestamp.from(entity.getDataVenda()));
        stmInsert.setString(5, entity.getStatus().name());
    }

    @Override
    protected String getQueryExclusao() {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmInsert, String valor) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    protected String getQueryAtualizacao() {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Venda entity) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stm, String valor) throws SQLException {
        stm.setString(1, valor);
    }

    @Override
    public Boolean cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            for (ProdutoQuantidade pq : entity.getProdutos()) {
                Long idProduto = pq.getProduto().getId();
                int quantidadeVenda = pq.getQuantidade();

                String sqlEstoque = "SELECT * FROM TB_ESTOQUE WHERE ID_PRODUTO_FK = ?";
                PreparedStatement stmEstoque = connection.prepareStatement(sqlEstoque);
                stmEstoque.setLong(1, idProduto);
                ResultSet rsEstoque = stmEstoque.executeQuery();

                if (rsEstoque.next()) {
                    int qtdEmEstoque = rsEstoque.getInt("QUANTIDADE");

                    if (qtdEmEstoque < quantidadeVenda) {
                        connection.rollback();
                        throw new DAOException("Estoque insuficiente para o produto: " + pq.getProduto().getNome());
                    }

                    int novaQtd = qtdEmEstoque - quantidadeVenda;
                    String sqlUpdateEstoque = "UPDATE TB_ESTOQUE SET QUANTIDADE = ? WHERE ID_PRODUTO_FK = ?";
                    PreparedStatement stmUpdate = connection.prepareStatement(sqlUpdateEstoque);
                    stmUpdate.setInt(1, novaQtd);
                    stmUpdate.setLong(2, idProduto);
                    stmUpdate.executeUpdate();
                    stmUpdate.close();

                } else {
                    connection.rollback();
                    throw new DAOException("Produto sem registro de estoque: " + pq.getProduto().getNome());
                }
                rsEstoque.close();
                stmEstoque.close();
            }

            stm = connection.prepareStatement(getQueryInsercao(), Statement.RETURN_GENERATED_KEYS);
            setParametrosQueryInsercao(stm, entity);
            int rowsAffected = stm.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet rs = stm.getGeneratedKeys()) {
                    if (rs.next()) {
                        entity.setId(rs.getLong(1));
                    }
                }

                for (ProdutoQuantidade prod : entity.getProdutos()) {
                    PreparedStatement stmProdQtd = connection.prepareStatement(getQueryInsercaoProdQuant());
                    setParametrosQueryInsercaoProdQuant(stmProdQtd, entity, prod);
                    stmProdQtd.executeUpdate();
                    stmProdQtd.close();
                }
            }
            connection.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new DAOException("ERRO TENTANDO FAZER ROLLBACK", ex);
            }
            throw new DAOException("ERRO CADASTRANDO VENDA E ATUALIZANDO ESTOQUE", e);
        } finally {
            closeConnection(connection, stm, null);
        }
    }


    @Override
    public Venda consultar(String valor) throws MaisDeUmRegistroException, TableException, DAOException {
        //TODO pode ser feito desta forma
//		Venda venda = super.consultar(valor);
//		Cliente cliente = clienteDAO.consultar(venda.getCliente().getId());
//		venda.setCliente(cliente);
//		return venda;

        //TODO Ou pode ser feito com join
        StringBuilder sb = sqlBaseSelect();
        sb.append("WHERE V.CODIGO = ? ");
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //validarMaisDeUmRegistro();
            connection = getConnection();
            stm = connection.prepareStatement(sb.toString());
            setParametrosQuerySelect(stm, valor);
            rs = stm.executeQuery();
            if (rs.next()) {
                Venda venda = VendaFactory.convert(rs);
                buscarAssociacaoVendaProdutos(connection, venda);
                return venda;
            }

        } catch (SQLException e) {
            throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
        } finally {
            closeConnection(connection, stm, rs);
        }
        return null;

    }

    private void buscarAssociacaoVendaProdutos(Connection connection, Venda venda)
            throws DAOException {
        PreparedStatement stmProd = null;
        ResultSet rsProd = null;
        try {
            String sbProd = "SELECT PQ.ID, PQ.QUANTIDADE, PQ.VALOR_TOTAL, " +
                    "P.ID AS ID_PRODUTO, P.CODIGO, P.NOME, P.DESCRICAO, P.VALOR " +
                    "FROM TB_PRODUTO_QUANTIDADE PQ " +
                    "INNER JOIN TB_PRODUTO P ON P.ID = PQ.ID_PRODUTO_FK " +
                    "WHERE PQ.ID_VENDA_FK = ?";
            stmProd = connection.prepareStatement(sbProd);
            stmProd.setLong(1, venda.getId());
            rsProd = stmProd.executeQuery();
            Set<ProdutoQuantidade> produtos = new HashSet<>();
            while(rsProd.next()) {
                ProdutoQuantidade prodQ = ProdutoQuantidadeFactory.convert(rsProd);
                produtos.add(prodQ);
            }
            venda.setProdutos(produtos);
            venda.recalcularValorTotalVenda();
        } catch (SQLException e) {
            throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
        } finally {
            closeConnection(connection, stmProd, rsProd);
        }
    }

    @Override
    public Collection<Venda> buscarTodos() throws DAOException {
        List<Venda> lista = new ArrayList<>();
        StringBuilder sb = sqlBaseSelect();

        try {
            Connection connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(sb.toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Venda venda = VendaFactory.convert(rs);
                buscarAssociacaoVendaProdutos(connection, venda);
                lista.add(venda);
            }

        } catch (SQLException e) {
            throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
        }
        return lista;
    }

    private StringBuilder sqlBaseSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT V.ID AS ID_VENDA, V.CODIGO, V.VALOR_TOTAL, V.DATA_VENDA, V.STATUS_VENDA, ");
        sb.append("C.ID AS ID_CLIENTE, C.NOME, C.CPF, C.TEL, C.ENDERECO, C.NUMERO, C.CIDADE, C.ESTADO ");
        sb.append("FROM TB_VENDA V ");
        sb.append("INNER JOIN TB_CLIENTE C ON V.ID_CLIENTE_FK = C.ID ");
        return sb;
    }

    private String getQueryInsercaoProdQuant() {
        return "INSERT INTO TB_PRODUTO_QUANTIDADE " +
                "(ID, ID_PRODUTO_FK, ID_VENDA_FK, QUANTIDADE, VALOR_TOTAL)" +
                "VALUES (nextval('sq_produto_quantidade'),?,?,?,?)";
    }

    private void setParametrosQueryInsercaoProdQuant(PreparedStatement stm, Venda venda, ProdutoQuantidade prod) throws SQLException {
        stm.setLong(1, prod.getProduto().getId());
        stm.setLong(2, venda.getId());
        stm.setInt(3, prod.getQuantidade());
        stm.setBigDecimal(4, prod.getValorTotal());
    }

}

package br.com.artnomic.test;

import br.com.artnomic.main.dao.generic.jdbc.dao.IProdutoDAO;
import br.com.artnomic.main.dao.generic.jdbc.dao.ProdutoDAO;
import br.com.artnomic.main.domain.Produto;
import org.junit.After;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

    private final IProdutoDAO produtoDAO;

    public ProdutoTest() {
        this.produtoDAO = new ProdutoDAO();
    }

    @After
    public void limparBase() throws Exception {
        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto prod : list) {
            produtoDAO.excluir(prod);
        }
    }

    @Test
    public void cadastrarEBuscarTest() throws Exception {
        Produto produto = criarProduto("P1");

        Integer countCad = produtoDAO.cadastrar(produto);

        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("P1");
        assertNotNull(produtoBD);
        assertProdutosSaoIguais(produto, produtoBD);
    }

    @Test
    public void excluirTest() throws Exception {
        Produto produto = criarProduto("P2");
        produtoDAO.cadastrar(produto);
        Produto produtoBD = produtoDAO.buscar("P2");
        assertNotNull(produtoBD);

        Integer countDel = produtoDAO.excluir(produtoBD);

        assertTrue(countDel == 1);
        Produto produtoExcluido = produtoDAO.buscar("P2");
        assertNull(produtoExcluido);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        produtoDAO.cadastrar(criarProduto("P3"));
        produtoDAO.cadastrar(criarProduto("P4"));

        List<Produto> list = produtoDAO.buscarTodos();

        assertNotNull(list);
        assertEquals(2, list.size());
    }

    @Test
    public void atualizarTest() throws Exception {
        Produto produto = criarProduto("P5");
        produtoDAO.cadastrar(produto);
        Produto produtoBD = produtoDAO.buscar("P5");
        assertNotNull(produtoBD);

        produtoBD.setNome("Headset Gamer Pro");
        produtoBD.setPreco(new BigDecimal("599.90"));
        Integer countUpdate = produtoDAO.atualizar(produtoBD);
        assertTrue(countUpdate == 1);

        Produto produtoAtualizado = produtoDAO.buscar("P5");
        assertNotNull(produtoAtualizado);
        assertProdutosSaoIguais(produtoBD, produtoAtualizado);
    }


    private Produto criarProduto(String codigo) {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setNome("Produto Teste " + codigo);
        produto.setPreco(new BigDecimal("150.50"));
        return produto;
    }

    private void assertProdutosSaoIguais(Produto esperado, Produto atual) {
        assertEquals(esperado.getCodigo(), atual.getCodigo());
        assertEquals(esperado.getNome(), atual.getNome());
        assertEquals(0, esperado.getPreco().compareTo(atual.getPreco()));
    }
}
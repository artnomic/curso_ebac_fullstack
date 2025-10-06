package br.com.artnomic.test;

import br.com.artnomic.main.dao.IProdutoDAO;
import br.com.artnomic.main.dao.ProdutoDAO;
import br.com.artnomic.main.domain.Produto;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;

import static org.junit.Assert.*;

public class ProdutoDAOTest {

    private final IProdutoDAO produtoDao;
    private final Random random;

    public ProdutoDAOTest() {
        this.produtoDao = new ProdutoDAO();
        this.random = new Random();
    }

    @Test
    public void cadastrar() throws Exception {
        Produto produto = criarProdutoUnico();
        assertNotNull(produto);
        assertNotNull(produto.getId());
    }

    @Test
    public void pesquisar() throws Exception {
        Produto produto = criarProdutoUnico();
        assertNotNull(produto);

        Produto produtoConsultado = produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoConsultado);
        assertEquals(produto.getCodigo(), produtoConsultado.getCodigo());
    }

    @Test
    public void excluir() throws Exception {
        Produto produto = criarProdutoUnico();
        assertNotNull(produto);

        produtoDao.excluir(produto.getCodigo());
        Produto produtoConsultado = produtoDao.consultar(produto.getCodigo());
        assertNull(produtoConsultado);
    }

    @Test
    public void alterar() throws Exception {
        Produto produto = criarProdutoUnico();
        assertNotNull(produto);

        produto.setNome("Produto Alterado");
        produtoDao.alterar(produto);

        Produto produtoAlterado = produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoAlterado);
        assertEquals("Produto Alterado", produtoAlterado.getNome());
    }

    private Produto criarProdutoUnico() throws Exception {
        Produto produto = new Produto();
        produto.setCodigo("P-" + random.nextInt(1000000)); // Código aleatório
        produto.setNome("Produto Teste");
        produto.setDescricao("Descrição Teste");
        produto.setValor(BigDecimal.TEN);
        produto.setMarca("Marca Teste");
        produtoDao.cadastrar(produto);
        return produto;
    }
}
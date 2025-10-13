package test.java.br.com.artnomic;

import main.java.br.com.artnomic.domain.Curso;
import main.java.br.com.artnomic.domain.Produto;
import main.java.br.com.artnomic.domain.dao.IProdutoDAO;
import main.java.br.com.artnomic.domain.dao.ProdutoDAO;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    public ProdutoTest() {
        produtoDAO = new ProdutoDAO();
    }

    @After
    public void end() {
        List<Produto> listProdutos = produtoDAO.buscarTodos();
        listProdutos.forEach(prod -> produtoDAO.excluir(prod));
    }

    @Test
    public void cadastrar() {
        Produto produto = new Produto();
        produto.setCodigo("XPT");
        produto.setDescricao("Produto de Beleza para Barba");
        produto.setNome("XPTO Shower Barber");
        produto.setValor(250d);
        produtoDAO.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());
    }
}

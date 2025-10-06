package br.com.artnomic.test;

import br.com.artnomic.main.dao.*;
import br.com.artnomic.main.domain.Cliente;
import br.com.artnomic.main.domain.Estoque;
import br.com.artnomic.main.domain.Produto;
import br.com.artnomic.main.domain.Venda;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Random;

import static org.junit.Assert.*;

public class VendaDAOTest {

    private final IVendaDAO vendaDao;
    private final IClienteDAO clienteDao;
    private final IProdutoDAO produtoDao;
    private final IEstoqueDAO estoqueDAO;
    private final Random random;

    public VendaDAOTest() {
        this.vendaDao = new VendaDAO();
        this.clienteDao = new ClienteDAO();
        this.produtoDao = new ProdutoDAO();
        this.estoqueDAO = new EstoqueDAO();
        this.random = new Random();
    }

    @Test
    public void pesquisar() throws Exception {
        Cliente cliente = criarClienteUnico();
        Produto produto = criarProdutoUnico();
        criarEstoque(produto, 10);

        Venda venda = criarVenda(cliente, produto);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);

        Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());
        assertNotNull(vendaConsultada);
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
    }

    @Test
    public void salvar() throws Exception {
        Cliente cliente = criarClienteUnico();
        Produto produto = criarProdutoUnico();
        criarEstoque(produto, 10);

        Venda venda = criarVenda(cliente, produto);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertEquals(0, new BigDecimal("20.00").compareTo(venda.getValorTotal()));
        assertEquals(Venda.Status.INICIADA, venda.getStatus());
    }

    @Test
    public void cancelarVenda() throws Exception {
        Cliente cliente = criarClienteUnico();
        Produto produto = criarProdutoUnico();
        criarEstoque(produto, 10);

        Venda venda = criarVenda(cliente, produto);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);

        vendaDao.cancelarVenda(venda);

        Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());
        assertEquals(Venda.Status.CANCELADA, vendaConsultada.getStatus());
    }

    @Test
    public void adicionarMaisProdutosDoMesmo() throws Exception {
        Cliente cliente = criarClienteUnico();
        Produto produto = criarProdutoUnico();
        criarEstoque(produto, 10); // Garante que há estoque

        Venda venda = criarVenda(cliente, produto);
        vendaDao.cadastrar(venda);

        Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());
        assertNotNull("A venda não foi encontrada no banco, o cadastro falhou.", vendaConsultada);
        vendaConsultada.adicionarProduto(produto, 1);

        assertEquals(3, (int) vendaConsultada.getQuantidadeTotalProdutos());
        BigDecimal valorTotal = new BigDecimal("30.00").setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(0, valorTotal.compareTo(vendaConsultada.getValorTotal()));
    }
    @Test
    public void adicionarMaisProdutosDiferentes() throws Exception {
        // ARRANGE: Cria todos os dados, incluindo dois produtos diferentes
        Cliente cliente = criarClienteUnico();
        Produto produto1 = criarProdutoUnico();
        Produto produto2 = criarProdutoUnico(); // Segundo produto
        criarEstoque(produto1, 10);
        criarEstoque(produto2, 10);

        Venda venda = criarVenda(cliente, produto1); // Cria venda com 2 unidades do produto1
        vendaDao.cadastrar(venda);

        // ACT: Consulta a venda e adiciona o produto diferente
        Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());
        assertNotNull("A venda não foi encontrada no banco, o cadastro falhou.", vendaConsultada);
        vendaConsultada.adicionarProduto(produto2, 1);

        // ASSERT: Verifica os totais
        assertEquals(3, (int) vendaConsultada.getQuantidadeTotalProdutos());
        // Valor esperado = (2 * valor prod1) + (1 * valor prod2) = (2 * 10) + (1 * 10) = 30
        BigDecimal valorTotal = new BigDecimal("30.00").setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(0, valorTotal.compareTo(vendaConsultada.getValorTotal()));
    }


    private Cliente criarClienteUnico() throws Exception {
        Cliente cliente = new Cliente();
        long onzeDigitos = 10000000000L + (long) (random.nextDouble() * 89999999999L);
        cliente.setCpf(onzeDigitos);
        cliente.setNome("Cliente Teste " + cliente.getCpf());
        cliente.setEmail("teste" + cliente.getCpf() + "@teste.com");
        cliente.setTel(11999999999L);
        cliente.setEnd("End Teste");
        cliente.setNumero(10);
        cliente.setCidade("SP");
        cliente.setEstado("SP");
        clienteDao.cadastrar(cliente);
        return cliente;
    }

    private Produto criarProdutoUnico() throws Exception {
        Produto produto = new Produto();
        produto.setCodigo("P-" + random.nextInt(1000000));
        produto.setNome("Produto Teste");
        produto.setDescricao("Descrição Teste");
        produto.setValor(BigDecimal.TEN.setScale(2, RoundingMode.HALF_UP));
        produto.setMarca("Marca Teste");
        produtoDao.cadastrar(produto);
        return produto;
    }

    private Estoque criarEstoque(Produto produto, Integer quantidade) throws Exception {
        Estoque estoque = new Estoque();
        estoque.setProduto(produto);
        estoque.setIdProdutoFk(produto.getId());
        estoque.setQuantidade(quantidade);
        estoqueDAO.cadastrar(estoque);
        return estoque;
    }

    private Venda criarVenda(Cliente cliente, Produto produto) {
        Venda venda = new Venda();
        venda.setCodigo("V-" + random.nextInt(100000));
        venda.setDataVenda(Instant.now());
        venda.setCliente(cliente);
        venda.setStatus(Venda.Status.INICIADA);
        venda.adicionarProduto(produto, 2);
        return venda;
    }
}
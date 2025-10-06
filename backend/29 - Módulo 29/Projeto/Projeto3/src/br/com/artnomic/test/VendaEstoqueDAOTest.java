package br.com.artnomic.test;

import br.com.artnomic.main.dao.*;
import br.com.artnomic.main.domain.Cliente;
import br.com.artnomic.main.domain.Estoque;
import br.com.artnomic.main.domain.Produto;
import br.com.artnomic.main.domain.Venda;
import br.com.artnomic.main.exceptions.DAOException;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

public class VendaEstoqueDAOTest {

    private final IVendaDAO vendaDAO;
    private final IClienteDAO clienteDAO;
    private final IProdutoDAO produtoDAO;
    private final IEstoqueDAO estoqueDAO;
    private final Random random;

    public VendaEstoqueDAOTest() {
        this.vendaDAO = new VendaDAO();
        this.clienteDAO = new ClienteDAO();
        this.produtoDAO = new ProdutoDAO();
        this.estoqueDAO = new EstoqueDAO();
        this.random = new Random();
    }

    @Test
    public void deveFinalizarVendaComSucessoEDiminuirEstoque() throws Exception {
        Cliente cliente = criarClienteUnico();
        Produto produto = criarProdutoUnico();
        Estoque estoque = criarEstoque(produto, 10);

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setCodigo("V-" + random.nextInt(100000));
        venda.setDataVenda(Instant.now());
        venda.setStatus(Venda.Status.INICIADA);
        venda.adicionarProduto(produto, 3);

        Boolean retorno = vendaDAO.cadastrar(venda);
        assertTrue(retorno);

        Estoque estoqueAtualizado = buscarEstoque(produto);
        assertNotNull(estoqueAtualizado);
        assertEquals(Integer.valueOf(7), estoqueAtualizado.getQuantidade());
    }

    @Test
    public void naoDeveFinalizarVendaPorFaltaDeEstoque() throws Exception {
        Cliente cliente = criarClienteUnico();
        Produto produto = criarProdutoUnico();
        Estoque estoque = criarEstoque(produto, 10);

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setCodigo("V-" + random.nextLong());
        venda.setDataVenda(Instant.now());
        venda.setStatus(Venda.Status.INICIADA);
        venda.adicionarProduto(produto, 11);

        DAOException thrown = assertThrows(DAOException.class, () -> {
            vendaDAO.cadastrar(venda);
        });

        assertTrue(thrown.getMessage().contains("Estoque insuficiente"));

        Estoque estoqueInalterado = buscarEstoque(produto);
        assertNotNull(estoqueInalterado);
        assertEquals(Integer.valueOf(10), estoqueInalterado.getQuantidade());
    }

    private Cliente criarClienteUnico() throws Exception {
        Cliente cliente = new Cliente();

        // --- CÓDIGO CORRIGIDO PARA GERAR CPF ALEATÓRIO E COMPATÍVEL ---
        // Gera um número aleatório de 11 dígitos
        long onzeDigitos = 10000000000L + (long) (random.nextDouble() * 89999999999L);
        cliente.setCpf(onzeDigitos);

        cliente.setNome("Cliente Teste");
        cliente.setEmail("teste" + cliente.getCpf() + "@teste.com");
        cliente.setTel(11999999999L);
        cliente.setEnd("End Teste");
        cliente.setNumero(10);
        cliente.setCidade("SP");
        cliente.setEstado("SP");
        clienteDAO.cadastrar(cliente);
        return cliente;
    }

    private Produto criarProdutoUnico() throws Exception {
        Produto produto = new Produto();
        produto.setCodigo("P-" + random.nextInt(1000000));
        produto.setNome("Produto Teste");
        produto.setDescricao("Descrição Teste");
        produto.setValor(BigDecimal.TEN);
        produto.setMarca("Marca Teste");
        produtoDAO.cadastrar(produto);
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

    private Estoque buscarEstoque(Produto produto) throws DAOException {
        Collection<Estoque> estoques = estoqueDAO.buscarTodos();
        return estoques.stream()
                .filter(e -> e.getIdProdutoFk().equals(produto.getId()))
                .findFirst()
                .orElse(null);
    }
}
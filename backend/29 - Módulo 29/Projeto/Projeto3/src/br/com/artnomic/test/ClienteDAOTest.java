package br.com.artnomic.test;

import br.com.artnomic.main.dao.*;
import br.com.artnomic.main.domain.Cliente;
import br.com.artnomic.main.domain.Estoque;
import br.com.artnomic.main.domain.Produto;
import br.com.artnomic.main.exceptions.DAOException;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

public class ClienteDAOTest {

    private final IClienteDAO clienteDao;
    private final Random random;

    private final IVendaDAO vendaDao;
    private final IProdutoDAO produtoDao;
    private final IEstoqueDAO estoqueDao;

    public ClienteDAOTest() {
        this.clienteDao = new ClienteDAO();
        this.random = new Random();

        this.vendaDao = new VendaDAO();
        this.produtoDao = new ProdutoDAO();
        this.estoqueDao = new EstoqueDAO();
    }

    @Test
    public void pesquisarCliente() throws Exception {
        Cliente cliente = criarClienteUnico();
        assertNotNull(cliente);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        assertNotNull(clienteConsultado);
        assertEquals(cliente.getNome(), clienteConsultado.getNome());
    }

    @Test
    public void salvarCliente() throws Exception {
        Cliente cliente = criarClienteUnico();

        assertNotNull(cliente);
        assertNotNull(cliente.getId());
    }

    @Test
    public void excluirCliente() throws Exception {
        Cliente cliente = criarClienteUnico();
        assertNotNull(cliente);

        clienteDao.excluir(cliente.getCpf());

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws Exception {
        Cliente cliente = criarClienteUnico();
        assertNotNull(cliente);

        cliente.setNome("Maria Silva");
        cliente.setEmail("maria.silva@novo.com");
        clienteDao.alterar(cliente);

        Cliente clienteAlterado = clienteDao.consultar(cliente.getCpf());
        assertNotNull(clienteAlterado);
        assertEquals("Maria Silva", clienteAlterado.getNome());
    }

    @Test
    public void buscarTodos() throws Exception {
        limparBancoDeDados();

        criarClienteUnico();
        criarClienteUnico();

        Collection<Cliente> list = clienteDao.buscarTodos();

        assertNotNull(list);
        assertEquals(2, list.size());

        limparBancoDeDados();
    }


    private Cliente criarClienteUnico() throws Exception {
        Cliente cliente = new Cliente();
        long onzeDigitos = 10000000000L + (long) (random.nextDouble() * 89999999999L);
        cliente.setCpf(onzeDigitos);
        cliente.setNome("Cliente Teste " + cliente.getCpf());
        cliente.setEmail("teste" + cliente.getCpf() + "@teste.com");
        cliente.setTel(11999999999L);
        cliente.setEnd("Endereço Teste");
        cliente.setNumero(10);
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");

        clienteDao.cadastrar(cliente);
        return cliente;
    }

    private void limparBancoDeDados() throws DAOException {
        vendaDao.limparTabelas();

        Collection<Estoque> estoques = estoqueDao.buscarTodos();
        for (Estoque est : estoques) {
            estoqueDao.excluir(est.getId());
        }

        Collection<Produto> produtos = produtoDao.buscarTodos();
        for (Produto prod : produtos) {
            produtoDao.excluir(prod.getCodigo());
        }

        Collection<Cliente> clientes = clienteDao.buscarTodos();
        for (Cliente cli : clientes) {
            clienteDao.excluir(cli.getCpf());
        }
    }
}
package test.br.com.artnomic;

import main.br.com.artnomic.dao.ClienteDAO;
import main.br.com.artnomic.dao.IClienteDAO;
import main.br.com.artnomic.domain.Cliente;
import main.br.com.artnomic.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.br.com.artnomic.dao.ClienteDaoMock;

public class ClienteDAOTest {

    private IClienteDAO clienteDAO;
    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDAO = new ClienteDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf("45018353899");
        cliente.setNome("Arthur Berson");
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");
        cliente.setNumero(341);
        cliente.setTel("+5511977191778");
        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void atualizarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Arthur PT Berson");
        clienteDAO.atualizar(cliente);

        Assert.assertEquals("Arthur PT Berson", cliente.getNome());
    }

    @Test
    public void excluirCliente() {
        clienteDAO.excluir(cliente.getCpf());
    }
}

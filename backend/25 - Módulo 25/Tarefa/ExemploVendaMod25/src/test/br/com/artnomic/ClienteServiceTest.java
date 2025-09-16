package test.br.com.artnomic;

import main.br.com.artnomic.dao.IClienteDAO;
import main.br.com.artnomic.domain.Cliente;
import main.br.com.artnomic.exceptions.TipoChaveNaoEncontradaException;
import main.br.com.artnomic.services.ClienteService;
import main.br.com.artnomic.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.br.com.artnomic.dao.ClienteDaoMock;

public class ClienteServiceTest {

    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
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
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void atualizarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Arthur PT Berson");
        clienteService.atualizar(cliente);

        Assert.assertEquals("Arthur PT Berson", cliente.getNome());
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }
}

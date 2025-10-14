package jpa;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Random;

import main.br.com.artnomic.dao.jpa.ClienteJpaDAO;
import main.br.com.artnomic.dao.jpa.IClienteJpaDAO;
import main.br.com.artnomic.domain.jpa.ClienteJpa;
import main.br.com.artnomic.exceptions.DAOException;
import main.br.com.artnomic.exceptions.MaisDeUmRegistroException;
import main.br.com.artnomic.exceptions.TableException;
import main.br.com.artnomic.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ClienteJpaDAOTest {

    private IClienteJpaDAO clienteDAO;

    private Random rd;

    public ClienteJpaDAOTest() {
        this.clienteDAO = new ClienteJpaDAO();
        rd = new Random();
    }

    @After
    public void end() throws DAOException {
        Collection<ClienteJpa> list = clienteDAO.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDAO.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException, TableException {
        ClienteJpa cliente = criarCliente();
        clienteDAO.cadastrar(cliente);

        ClienteJpa clienteConsultado = clienteDAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDAO.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteJpa clienteConsultado = clienteDAO.consultar(retorno.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDAO.excluir(cliente);

        ClienteJpa clienteConsultado1 = clienteDAO.consultar(retorno.getId());
        Assert.assertNull(clienteConsultado1);
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDAO.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteJpa clienteConsultado = clienteDAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDAO.excluir(cliente);
        clienteConsultado = clienteDAO.consultar(cliente.getId());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDAO.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteJpa clienteConsultado = clienteDAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Rodrigo Pires");
        clienteDAO.alterar(clienteConsultado);

        ClienteJpa clienteAlterado = clienteDAO.consultar(clienteConsultado.getId());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Rodrigo Pires", clienteAlterado.getNome());

        clienteDAO.excluir(cliente);
        clienteConsultado = clienteDAO.consultar(clienteAlterado.getId());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDAO.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteJpa cliente1 = criarCliente();
        ClienteJpa retorno1 = clienteDAO.cadastrar(cliente1);
        Assert.assertNotNull(retorno1);

        Collection<ClienteJpa> list = clienteDAO.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteDAO.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Collection<ClienteJpa> list1 = clienteDAO.buscarTodos();
        assertTrue(list1 != null);
        assertTrue(list1.size() == 0);
    }

    private ClienteJpa criarCliente() {
        ClienteJpa cliente = new ClienteJpa();
        cliente.setCpf(rd.nextLong());
        cliente.setNome("Rodrigo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        return cliente;
    }

}
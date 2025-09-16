package test.br.com.artnomic.dao;

import main.br.com.artnomic.dao.IClienteDAO;
import main.br.com.artnomic.domain.Cliente;
import main.br.com.artnomic.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;
import java.util.List;

public class ClienteDaoMock implements IClienteDAO {

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(String valor) {

    }

    @Override
    public void atualizar(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente consultar(String valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return List.of();
    }
}

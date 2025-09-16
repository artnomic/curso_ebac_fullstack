package main.br.com.artnomic.dao;

import main.br.com.artnomic.dao.generics.GenericDAO;
import main.br.com.artnomic.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {

    }
}

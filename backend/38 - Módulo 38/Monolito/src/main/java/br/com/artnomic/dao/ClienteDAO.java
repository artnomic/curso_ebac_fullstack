package br.com.artnomic.dao;

import br.com.artnomic.dao.generic.GenericDAO;
import br.com.artnomic.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super(Cliente.class);
    }

}
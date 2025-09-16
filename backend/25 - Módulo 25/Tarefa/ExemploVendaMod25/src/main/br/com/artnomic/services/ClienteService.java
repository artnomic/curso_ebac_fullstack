package main.br.com.artnomic.services;

import main.br.com.artnomic.dao.IClienteDAO;
import main.br.com.artnomic.domain.Cliente;
import main.br.com.artnomic.services.generics.GenericService;

public class ClienteService extends GenericService<Cliente> implements IClienteService {

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }
}

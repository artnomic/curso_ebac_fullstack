package br.com.artnomic.service;

import br.com.artnomic.dao.IClienteDAO;
import br.com.artnomic.domain.Cliente;
import br.com.artnomic.exceptions.*;
import br.com.artnomic.service.generic.GenericService;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    @Inject
    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
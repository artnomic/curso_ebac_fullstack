package br.com.artnomic.service;

import br.com.artnomic.domain.Cliente;
import br.com.artnomic.exceptions.DAOException;
import br.com.artnomic.service.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    Cliente buscarPorCPF(Long cpf) throws DAOException;

}

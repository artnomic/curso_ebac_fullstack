package main.br.com.artnomic.services;

import main.br.com.artnomic.domain.Cliente;
import main.br.com.artnomic.exceptions.DAOException;
import main.br.com.artnomic.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    //	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
    Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}

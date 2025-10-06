package br.com.artnomic.main.service;

import br.com.artnomic.main.domain.Cliente;
import br.com.artnomic.main.exceptions.DAOException;
import br.com.artnomic.main.service.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    //	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
    Cliente buscarPorCPF(Long cpf) throws DAOException;
    //
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
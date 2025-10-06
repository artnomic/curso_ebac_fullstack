package br.com.artnomic.main.dao;

import br.com.artnomic.main.dao.generic.IGenericDAO;
import br.com.artnomic.main.domain.Venda;
import br.com.artnomic.main.exceptions.DAOException;
import br.com.artnomic.main.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void limparTabelas() throws DAOException;
}

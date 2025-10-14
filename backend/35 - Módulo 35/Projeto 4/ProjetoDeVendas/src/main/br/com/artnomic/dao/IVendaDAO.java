package main.br.com.artnomic.dao;

import main.br.com.artnomic.dao.generic.IGenericDAO;
import main.br.com.artnomic.domain.Venda;
import main.br.com.artnomic.exceptions.DAOException;
import main.br.com.artnomic.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}

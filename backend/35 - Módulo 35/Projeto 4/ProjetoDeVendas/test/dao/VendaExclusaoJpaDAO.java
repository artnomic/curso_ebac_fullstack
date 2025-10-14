package dao;

import main.br.com.artnomic.dao.generic.jpa.GenericJpaDAO;
import main.br.com.artnomic.dao.jpa.IVendaJpaDAO;
import main.br.com.artnomic.domain.jpa.VendaJpa;
import main.br.com.artnomic.exceptions.DAOException;
import main.br.com.artnomic.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public class VendaExclusaoJpaDAO extends GenericJpaDAO<VendaJpa, Long> implements IVendaJpaDAO {

    public VendaExclusaoJpaDAO() {
        super(VendaJpa.class);
    }

    @Override
    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public VendaJpa consultarComCollection(Long id) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

}

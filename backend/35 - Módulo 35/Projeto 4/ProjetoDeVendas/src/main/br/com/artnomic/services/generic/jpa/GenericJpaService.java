package main.br.com.artnomic.services.generic.jpa;

import main.br.com.artnomic.dao.Persistente;
import main.br.com.artnomic.dao.generic.jpa.IGenericJpaDAO;
import main.br.com.artnomic.dao.generic.IGenericDAO;
import main.br.com.artnomic.exceptions.DAOException;
import main.br.com.artnomic.exceptions.MaisDeUmRegistroException;
import main.br.com.artnomic.exceptions.TableException;
import main.br.com.artnomic.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public abstract class GenericJpaService<T extends Persistente, E extends Serializable>
        implements IGenericJpaService<T, E> {

    protected IGenericJpaDAO<T, E> dao;

    public GenericJpaService(IGenericJpaDAO<T, E> dao) {
        this.dao = dao;
    }


    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(T entity) throws DAOException {
        this.dao.excluir(entity);
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.alterar(entity);
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        return this.dao.consultar(valor);
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodos();
    }


}
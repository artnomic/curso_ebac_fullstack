package main.br.com.artnomic.services.generics;

import main.br.com.artnomic.dao.generics.IGenericDAO;
import main.br.com.artnomic.domain.Persistente;
import main.br.com.artnomic.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public class GenericService<T extends Persistente> implements IGenericService<T> {

    protected IGenericDAO<T> dao;

    public GenericService(IGenericDAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public Boolean salvar(T entity) throws TipoChaveNaoEncontradaException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(String valor) {
        this.dao.excluir(valor);
    }

    @Override
    public void atualizar(T entity) throws TipoChaveNaoEncontradaException {
        this.dao.atualizar(entity);
    }

    @Override
    public T consultar(String valor) {
        return this.dao.consultar(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        return this.dao.buscarTodos();
    }
}

package main.br.com.artnomic.dao.generics;

import main.br.com.artnomic.domain.Persistente;
import main.br.com.artnomic.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public interface IGenericDAO <T extends Persistente> {

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    void excluir(String valor);

    public void atualizar(T entity) throws TipoChaveNaoEncontradaException;

    public T consultar(String valor);

    public Collection<T> buscarTodos();

}

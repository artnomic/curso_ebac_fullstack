package main.br.com.artnomic.services.generics;

import main.br.com.artnomic.domain.Persistente;
import main.br.com.artnomic.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public interface IGenericService <T extends Persistente> {
    Boolean salvar(T entity) throws TipoChaveNaoEncontradaException;
    void excluir(String valor);
    void atualizar(T entity) throws TipoChaveNaoEncontradaException;
    T consultar(String valor);
    Collection<T> buscarTodos();
}

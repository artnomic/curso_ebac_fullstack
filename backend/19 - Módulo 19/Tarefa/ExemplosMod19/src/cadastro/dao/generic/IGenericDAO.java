package cadastro.dao.generic;

import cadastro.domain.IPersistente;

import java.util.Collection;

public interface IGenericDAO <T extends IPersistente> {
    public Boolean cadastrar(T entity);

    public void excluir(Long valor);

    public void alterar(T entity);

    public T consultar(Long valor);

    public Collection<T> buscarTodos();
}

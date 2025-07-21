package exercicio.carros.dao;

import java.util.List;

public interface IGenericDAO<T, ID> {
    void adicionar(T entidade);
    T buscarPorId(ID id);
    void atualizar(T entidade);
    void remover(ID id);
    List<T> buscarTodos();
}

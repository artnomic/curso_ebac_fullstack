package exercicio.carros.dao;

import java.util.*;

public class GenericDAO<T, ID> implements IGenericDAO<T, ID> {
    private Map<ID, T> repositorio = new HashMap<>();

    @Override
    public void adicionar(T entidade) {
        System.out.println("Adicionando entidade: " + entidade.getClass().getSimpleName());
    }

    @Override
    public T buscarPorId(ID id) {
        System.out.println("Buscando entidade com ID: " + id);
        return repositorio.get(id);
    }

    @Override
    public void atualizar(T entidade) {
        System.out.println("Atualizando entidade: " + entidade.getClass().getSimpleName());
    }

    @Override
    public void remover(ID id) {
        System.out.println("Removendo entidade com ID: " + id);
        repositorio.remove(id);
    }

    @Override
    public List<T> buscarTodos() {
        System.out.println("Buscando todas as entidades.");
        return new ArrayList<>(repositorio.values());
    }

    protected void put(ID id, T entidade) {
        repositorio.put(id, entidade);
    }
}

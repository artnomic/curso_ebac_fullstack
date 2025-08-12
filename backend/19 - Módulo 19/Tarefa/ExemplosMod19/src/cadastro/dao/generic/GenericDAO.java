package cadastro.dao.generic;

import cadastro.anotation.TipoChave;
import cadastro.domain.IPersistente;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends IPersistente> implements IGenericDAO<T> {

    protected Map<Class, Map<Long, T>> map;

    public abstract Class<T> getTipoClasse();

    public abstract void atualizarDados(T entity, T entityCadastrado);

    public GenericDAO() {
        this.map = new HashMap<>();
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        if (mapaInterno == null) {
            mapaInterno = new HashMap<>();
            this.map.put(getTipoClasse(), mapaInterno);
        }
    }

    public Long getChave(T entity) {
        Field[] field = entity.getClass().getDeclaredFields();

        for (Field fld : field) {
            if (fld.isAnnotationPresent(TipoChave.class)) {
                TipoChave tipoChave = fld.getAnnotation(TipoChave.class);

                String nomeMetodo = tipoChave.value();

                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    Long value = (Long) method.invoke(entity);
                    return value;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        return null;
    }

    @Override
    public Boolean cadastrar(T entity) {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());

        Long chave = getChave(entity);

        if (mapaInterno.containsKey(chave)) {
            return false;
        }


        mapaInterno.put(chave, entity);
        return true;
    }

    @Override
    public void excluir(Long valor) {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        T entityCadastrado = mapaInterno.get(valor);

        if (entityCadastrado != null) {
            this.map.remove(valor, entityCadastrado);
        }
    }

    @Override
    public void alterar(T entity) {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Long chave = getChave(entity);

        T entityCadastrado = mapaInterno.get(chave);

        if (entityCadastrado != null) {
            atualizarDados(entity, entityCadastrado);
        }
    }

    @Override
    public Collection<T> buscarTodos() {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        return mapaInterno.values();
    }

    @Override
    public T consultar(Long valor) {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        return mapaInterno.get(valor);
    }
}

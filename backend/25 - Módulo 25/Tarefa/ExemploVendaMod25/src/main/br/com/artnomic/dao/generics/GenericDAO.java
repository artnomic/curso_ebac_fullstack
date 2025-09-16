package main.br.com.artnomic.dao.generics;

import main.br.com.artnomic.anotacao.TipoChave;
import main.br.com.artnomic.domain.Persistente;
import main.br.com.artnomic.exceptions.TipoChaveNaoEncontradaException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

public abstract class GenericDAO<T extends Persistente> implements IGenericDAO<T> {

    private SingletonMap singletonMap;
    public abstract Class<T> getTipoClasse();
    public abstract void atualizarDados(T entity, T entityCadastrado);

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    public Long getChave(T entity) throws TipoChaveNaoEncontradaException {
        Field[] fields = entity.getClass().getDeclaredFields();
        Long returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(TipoChave.class)) {
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMetodo = tipoChave.value();

                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    returnValue = (Long) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new TipoChaveNaoEncontradaException("Chave principal do objeto" + entity.getClass() + " ");
                }
            }
        }
        if (returnValue == null) {
            String msg = "Chave principal do objeto: " + entity.getClass() + " não encontrada";
            System.out.println("**** ERROR **** " + msg);
            throw new TipoChaveNaoEncontradaException(msg);
        }
        return null;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
        Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        Long chave = getChave(entity);

        if (mapaInterno.containsKey(chave)) {
            return false;
        }

        mapaInterno.put(chave, entity);
        return true;
    }

    @Override
    public void excluir(String valor) {
        Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        T objetoCadastrado = mapaInterno.get(valor);

        if (objetoCadastrado != null) {
            mapaInterno.remove(valor, objetoCadastrado);
        }
    }

    @Override
    public void atualizar(T entity) throws TipoChaveNaoEncontradaException {
        Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        Long chave = getChave(entity);

        T objetoCadastrado = mapaInterno.get(chave);
        if (objetoCadastrado != null) {
            atualizarDados(entity, objetoCadastrado);
        }
    }

    @Override
    public T consultar(String valor) {
        Map<String, T> mapaInterno = (Map<String, T>) this.singletonMap.getMap().get(getTipoClasse());
        return mapaInterno.get(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        return mapaInterno.values();
    }
}

package main.java.br.com.artnomic.domain.dao;

import main.java.br.com.artnomic.domain.Marca;
import main.java.br.com.artnomic.domain.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MarcaDAO implements IMarcaDAO {

    @Override
    public Marca cadastrar(Marca marca) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(marca);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return marca;
    }

    @Override
    public void excluir(Marca marca) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        marca = entityManager.merge(marca);
        entityManager.remove(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public List<Marca> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Marca> query = builder.createQuery(Marca.class);
        Root<Marca> root = query.from(Marca.class);
        query.select(root);

        TypedQuery<Marca> tpQuery =
                entityManager.createQuery(query);
        List<Marca> list = tpQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }
}

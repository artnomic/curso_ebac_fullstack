package main.java.br.com.artnomic.domain.dao;

import main.java.br.com.artnomic.domain.Acessorio;
import main.java.br.com.artnomic.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AcessorioDAO implements IAcessorioDAO {

    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(acessorio);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return acessorio;
    }

    @Override
    public void excluir(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        acessorio = entityManager.merge(acessorio);
        entityManager.remove(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public List<Acessorio> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Acessorio> query = builder.createQuery(Acessorio.class);
        Root<Acessorio> root = query.from(Acessorio.class);
        query.select(root);

        TypedQuery<Acessorio> tpQuery =
                entityManager.createQuery(query);
        List<Acessorio> list = tpQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }
}

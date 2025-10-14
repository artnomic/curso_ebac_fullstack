package main.java.br.com.artnomic.domain.dao;

import main.java.br.com.artnomic.domain.Carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CarroDAO implements ICarroDAO {

    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return carro;
    }

    @Override
    public void excluir(Carro carro) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        carro = entityManager.merge(carro);
        entityManager.remove(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public List<Carro> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Carro> query = builder.createQuery(Carro.class);
        Root<Carro> root = query.from(Carro.class);
        query.select(root);

        TypedQuery<Carro> tpQuery =
                entityManager.createQuery(query);
        List<Carro> list = tpQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }
}

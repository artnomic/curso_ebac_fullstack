package main.br.com.artnomic.dao.jpa;

import main.br.com.artnomic.dao.generic.jpa.GenericJpaDB1DAO;
import main.br.com.artnomic.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

    public ProdutoJpaDAO() {
        super(ProdutoJpa.class);
    }

}

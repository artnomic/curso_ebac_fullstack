package main.br.com.artnomic.dao.jpa;

import main.br.com.artnomic.dao.generic.jpa.GenericJpaDAO;
import main.br.com.artnomic.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

    public ProdutoJpaDAO() {
        super(ProdutoJpa.class);
    }

}

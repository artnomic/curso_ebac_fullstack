package main.br.com.artnomic.dao.jpa;


import main.br.com.artnomic.dao.generic.jpa.GenericJpaDB3DAO;
import main.br.com.artnomic.domain.jpa.ClienteJpa2;

public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDAO<ClienteJpa2> {

    public ClienteJpaDB3DAO() {
        super(ClienteJpa2.class);
    }

}
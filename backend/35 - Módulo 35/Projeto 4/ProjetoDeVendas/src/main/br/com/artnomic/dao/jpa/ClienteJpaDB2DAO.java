package main.br.com.artnomic.dao.jpa;

import main.br.com.artnomic.dao.generic.jpa.GenericJpaDB2DAO;
import main.br.com.artnomic.domain.jpa.ClienteJpa;

public class ClienteJpaDB2DAO  extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

    public ClienteJpaDB2DAO() {
        super(ClienteJpa.class);
    }

}
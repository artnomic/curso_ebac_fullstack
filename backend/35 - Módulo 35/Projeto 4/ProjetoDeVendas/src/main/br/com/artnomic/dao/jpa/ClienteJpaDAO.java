package main.br.com.artnomic.dao.jpa;

import main.br.com.artnomic.dao.generic.jpa.GenericJpaDB1DAO;
import main.br.com.artnomic.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {
    public ClienteJpaDAO() {
        super(ClienteJpa.class);
    }
}

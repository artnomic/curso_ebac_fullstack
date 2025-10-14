package main.br.com.artnomic.dao.jpa;

import main.br.com.artnomic.dao.generic.jpa.GenericJpaDAO;
import main.br.com.artnomic.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

    public ClienteJpaDAO() {
        super(ClienteJpa.class);
    }

}

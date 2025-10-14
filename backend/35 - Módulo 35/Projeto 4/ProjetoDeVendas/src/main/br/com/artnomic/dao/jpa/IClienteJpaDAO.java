package main.br.com.artnomic.dao.jpa;

import main.br.com.artnomic.dao.Persistente;
import main.br.com.artnomic.dao.generic.jpa.IGenericJpaDAO;


public interface IClienteJpaDAO<T extends Persistente> extends IGenericJpaDAO<T, Long>{

}

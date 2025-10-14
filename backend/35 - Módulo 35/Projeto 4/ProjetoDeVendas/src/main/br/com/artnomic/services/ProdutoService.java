package main.br.com.artnomic.services;

import main.br.com.artnomic.dao.IProdutoDAO;
import main.br.com.artnomic.domain.Produto;
import main.br.com.artnomic.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}
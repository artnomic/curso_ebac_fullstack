package br.com.artnomic.main.service;

import br.com.artnomic.main.dao.IProdutoDAO;
import br.com.artnomic.main.domain.Produto;
import br.com.artnomic.main.service.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}
package br.com.artnomic.contratos.service;

import br.com.artnomic.contratos.dao.IContratoDao;

public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String buscar(Integer id) {
        return  contratoDao.buscar(id);
    }

    @Override
    public String atualizar(Integer id) {
        return contratoDao.atualizar(id);
    }

    @Override
    public String excluir(Integer id) {
        return contratoDao.excluir(id);
    }
}

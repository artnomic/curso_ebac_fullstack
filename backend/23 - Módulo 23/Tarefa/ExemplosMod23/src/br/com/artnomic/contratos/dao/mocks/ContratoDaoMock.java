package br.com.artnomic.contratos.dao.mocks;

import br.com.artnomic.contratos.dao.IContratoDao;

public class ContratoDaoMock implements IContratoDao {

    @Override
    public void salvar() {

    }

    @Override
    public String buscar(Integer id) {
        return "Encontrei";
    }

    @Override
    public String atualizar(Integer id) {
        return "Atualizei";
    }

    @Override
    public String excluir(Integer id) {
        return "Excluido";
    }
}

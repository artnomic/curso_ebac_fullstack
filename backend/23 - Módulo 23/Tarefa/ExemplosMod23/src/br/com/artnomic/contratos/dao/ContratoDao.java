package br.com.artnomic.contratos.dao;

public class ContratoDao implements IContratoDao {

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não existe Banco de Dados configurado");
    }

    @Override
    public String buscar(Integer id) {
        throw new UnsupportedOperationException("Não existe Banco de Dados configurado");
    }

    @Override
    public String atualizar(Integer id) {
        throw new UnsupportedOperationException("Não existe Banco de Dados configurado");
    }

    @Override
    public String excluir(Integer id) {
        throw new UnsupportedOperationException("Não existe Banco de Dados configurado");
    }
}

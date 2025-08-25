package br.com.artnomic.contratos.dao;

public interface IContratoDao {
    void salvar();
    String buscar(Integer id);
    String atualizar(Integer id);
    String excluir(Integer id);
}

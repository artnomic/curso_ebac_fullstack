package br.com.artnomic.contratos.service;

public interface IContratoService {
    String salvar();
    String buscar(Integer id);
    String atualizar(Integer id);
    String excluir(Integer id);
}

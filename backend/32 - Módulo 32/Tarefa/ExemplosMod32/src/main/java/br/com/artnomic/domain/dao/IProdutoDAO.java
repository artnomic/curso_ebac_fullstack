package main.java.br.com.artnomic.domain.dao;

import main.java.br.com.artnomic.domain.Produto;

import java.util.List;

public interface IProdutoDAO {
    public Produto cadastrar(Produto produto);
    public void excluir(Produto produto);
    public List<Produto> buscarTodos();
}

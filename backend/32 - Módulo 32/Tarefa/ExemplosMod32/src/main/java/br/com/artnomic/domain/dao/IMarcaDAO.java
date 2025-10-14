package main.java.br.com.artnomic.domain.dao;

import main.java.br.com.artnomic.domain.Marca;

import java.util.List;

public interface IMarcaDAO {
    Marca cadastrar(Marca marca);
    public void excluir(Marca marca);
    public List<Marca> buscarTodos();
}
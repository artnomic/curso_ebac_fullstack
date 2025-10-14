package main.java.br.com.artnomic.domain.dao;

import main.java.br.com.artnomic.domain.Carro;

import java.util.List;

public interface ICarroDAO {
    Carro cadastrar(Carro carro);
    public void excluir(Carro carro);
    public List<Carro> buscarTodos();
}

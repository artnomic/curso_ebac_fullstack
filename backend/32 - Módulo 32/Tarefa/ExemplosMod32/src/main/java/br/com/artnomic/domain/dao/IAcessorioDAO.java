package main.java.br.com.artnomic.domain.dao;

import main.java.br.com.artnomic.domain.Acessorio;

import java.util.List;

public interface IAcessorioDAO {
    Acessorio cadastrar(Acessorio acessorio);
    public void excluir(Acessorio acessorio);
    public List<Acessorio> buscarTodos();
}

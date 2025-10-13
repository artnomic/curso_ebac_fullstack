package main.java.br.com.artnomic.domain.dao;

import main.java.br.com.artnomic.domain.Curso;

import java.util.List;

public interface ICursoDAO {
    public Curso cadastrar(Curso curso);
    public void excluir(Curso curso);
    public List<Curso> buscarTodos();
}

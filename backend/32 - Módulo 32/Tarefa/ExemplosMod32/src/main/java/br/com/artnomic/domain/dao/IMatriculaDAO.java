package main.java.br.com.artnomic.domain.dao;

import main.java.br.com.artnomic.domain.Curso;
import main.java.br.com.artnomic.domain.Matricula;

import java.util.List;

public interface IMatriculaDAO {
    public Matricula cadastrar (Matricula matricula);
    public void excluir(Matricula matricula);
    public List<Matricula> buscarTodos();
    Matricula buscarPorCodigoCurso(String codigoCurso);
    Matricula buscarPorCurso(Curso curso);
    Matricula buscarPorCodigoCursoCriteria(String codigoCurso);
    Matricula buscarPorCursoCriteria(Curso curso);
}

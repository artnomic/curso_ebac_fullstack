package test.java.br.com.artnomic;

import main.java.br.com.artnomic.domain.Curso;
import main.java.br.com.artnomic.domain.dao.CursoDAO;
import main.java.br.com.artnomic.domain.dao.ICursoDAO;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class CursoTest {

    private ICursoDAO cursoDAO;

    public CursoTest() {
        cursoDAO = new CursoDAO();
    }

    @After
    public void end() {
        List<Curso> listCursos = cursoDAO.buscarTodos();
        listCursos.forEach(cur -> cursoDAO.excluir(cur));
    }

    @Test
    public void Cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("CURSO DE TESTE");
        curso.setNome("JAVA Backend");
        cursoDAO.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());
    }
}

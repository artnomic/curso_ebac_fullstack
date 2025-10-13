package test.java.br.com.artnomic;

import main.java.br.com.artnomic.domain.Curso;
import main.java.br.com.artnomic.domain.Matricula;
import main.java.br.com.artnomic.domain.dao.CursoDAO;
import main.java.br.com.artnomic.domain.dao.ICursoDAO;
import main.java.br.com.artnomic.domain.dao.IMatriculaDAO;
import main.java.br.com.artnomic.domain.dao.MatriculaDAO;
import org.junit.*;

import java.time.Instant;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MatriculaTest {

    private IMatriculaDAO matriculaDAO;
    private ICursoDAO cursoDAO;


    public MatriculaTest() {
        matriculaDAO = new MatriculaDAO();
        cursoDAO = new CursoDAO();
    }

    @After
    public void end() {
        List<Matricula> list = matriculaDAO.buscarTodos();
        list.forEach(mat -> matriculaDAO.excluir(mat));

        List<Curso> listCursos = cursoDAO.buscarTodos();
        listCursos.forEach(cur -> cursoDAO.excluir(cur));
    }

    @Test
    public void cadastrar() {
        Curso curso = criarCurso("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat = matriculaDAO.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());
    }

    @Test
    public void pesquisarPorCurso() {
        Curso curso = criarCurso("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat = matriculaDAO.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());

        Matricula matricBD = matriculaDAO.buscarPorCurso(curso);
        assertNotNull(matricBD);
        assertEquals(mat.getId(), matricBD.getId());
    }

    @Test
    public void pesquisarPorCodigoCurso() {
        Curso curso = criarCurso("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat = matriculaDAO.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());

        Matricula matricBD = matriculaDAO.buscarPorCodigoCurso(curso.getCodigo());
        assertNotNull(matricBD);
        assertEquals(mat.getId(), matricBD.getId());
    }

    @Test
    public void pesquisarPorCodigoCursoCriteria() {
        Curso curso = criarCurso("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat = matriculaDAO.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());

        Matricula matricBD = matriculaDAO.buscarPorCodigoCursoCriteria(curso.getCodigo());
        assertNotNull(matricBD);
        assertEquals(mat.getId(), matricBD.getId());
    }

    @Test
    public void pesquisarPorCursoCriteria() {
        Curso curso = criarCurso("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat = matriculaDAO.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());

        Matricula matricBD = matriculaDAO.buscarPorCursoCriteria(curso);
        assertNotNull(matricBD);
        assertEquals(mat.getId(), matricBD.getId());
    }

    private Curso criarCurso(String codigo) {
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setDescricao("CURSO TESTE");
        curso.setNome("Curso de Java Backend");
        return cursoDAO.cadastrar(curso);
    }
}

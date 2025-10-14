package test.java.br.com.artnomic;

import main.java.br.com.artnomic.domain.Acessorio;
import main.java.br.com.artnomic.domain.Carro;
import main.java.br.com.artnomic.domain.Marca;
import main.java.br.com.artnomic.domain.dao.*;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

public class CadastroCarroTest {

    private ICarroDAO carroDAO;
    private IMarcaDAO marcaDAO;
    private IAcessorioDAO acessorioDAO;

    public CadastroCarroTest() {
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();
        acessorioDAO = new AcessorioDAO();
    }

    @After
    public void end() {
        List<Carro> carros = carroDAO.buscarTodos();
        if (carros != null) {
            for (Carro carro : carros) {
                carroDAO.excluir(carro);
            }
        }

        List<Acessorio> acessorios = acessorioDAO.buscarTodos();
        if (acessorios != null) {
            for (Acessorio acessorio : acessorios) {
                acessorioDAO.excluir(acessorio);
            }
        }

        List<Marca> marcas = marcaDAO.buscarTodos();
        if (marcas != null) {
            for (Marca marca : marcas) {
                marcaDAO.excluir(marca);
            }
        }
    }

    @Test
    public void Cadastrar() {
        Marca marca = new Marca();
        marca.setNome("Toyota");
        marcaDAO.cadastrar(marca);

        Acessorio acessorio1 = new Acessorio();
        acessorio1.setNome("Teto Solar");
        acessorioDAO.cadastrar(acessorio1);

        Acessorio acessorio2 = new Acessorio();
        acessorio2.setNome("Kit Multimídia");
        acessorioDAO.cadastrar(acessorio2);

        List<Acessorio> listaAcessorios = new ArrayList<>();
        listaAcessorios.add(acessorio1);
        listaAcessorios.add(acessorio2);

        Carro carro = new Carro();
        carro.setModelo("Corolla");
        carro.setMarca(marca);
        carro.setAcessorios(listaAcessorios);

        carroDAO.cadastrar(carro);

        assertNotNull(carro);
        assertNotNull(carro.getId());
        assertEquals("Toyota", carro.getMarca().getNome());
        assertEquals(2, carro.getAcessorios().size());
    }
}

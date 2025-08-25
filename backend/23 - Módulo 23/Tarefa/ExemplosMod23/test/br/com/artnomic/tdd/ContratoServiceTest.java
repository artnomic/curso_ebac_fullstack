package br.com.artnomic.tdd;

import br.com.artnomic.contratos.dao.ContratoDao;
import br.com.artnomic.contratos.dao.IContratoDao;
import br.com.artnomic.contratos.dao.mocks.ContratoDaoMock;
import br.com.artnomic.contratos.service.ContratoService;
import br.com.artnomic.contratos.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao mock = new ContratoDaoMock();
        IContratoService service = new ContratoService(mock);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroAoSalvarComBancoDeDadosTest() {
        IContratoDao mock = new ContratoDao();
        IContratoService service = new ContratoService(mock);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void buscarTest() {
        IContratoDao mock = new ContratoDaoMock();
        IContratoService service = new ContratoService(mock);
        String retorno = service.buscar(1);
        Assert.assertEquals("Encontrei", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroAoBuscarComBancoDeDadosTest() {
        IContratoDao mock = new ContratoDao();
        IContratoService service = new ContratoService(mock);
        String retorno = service.buscar(1);
        Assert.assertEquals("Encontrei", retorno);
    }

    @Test
    public void atualizarTest() {
        IContratoDao mock = new ContratoDaoMock();
        IContratoService service = new ContratoService(mock);
        String retorno = service.atualizar(1);
        Assert.assertEquals("Atualizei", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroAoAtualizarComBancoDeDadosTest() {
        IContratoDao mock = new ContratoDao();
        IContratoService service = new ContratoService(mock);
        String retorno = service.atualizar(1);
        Assert.assertEquals("Atualizei", retorno);
    }

    @Test
    public void excluirTest() {
        IContratoDao mock = new ContratoDaoMock();
        IContratoService service = new ContratoService(mock);
        String retorno = service.excluir(1);
        Assert.assertEquals("Excluido", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroAoExcluirComBancoDeDadosTest() {
        IContratoDao mock = new ContratoDao();
        IContratoService service = new ContratoService(mock);
        String retorno = service.excluir(1);
        Assert.assertEquals("Excluido", retorno);
    }
}

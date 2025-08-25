import br.com.artnomic.clientes.dao.ClienteDao;
import br.com.artnomic.clientes.dao.ClienteDaoMock;
import br.com.artnomic.clientes.dao.IClienteDao;
import br.com.artnomic.clientes.service.ClienteService;
import org.junit.Assert;
import org.junit.Test;

public class ClienteServiceTest {

    @Test
    public void salvarTest() {
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();

        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {
        IClienteDao dao = new ClienteDao();
        ClienteService service = new ClienteService(dao);
        String retorno = service.salvar();

        Assert.assertEquals("Sucesso", retorno);
    }
}

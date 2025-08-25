import br.com.artnomic.clientes.TesteCliente;
import org.junit.Assert;
import org.junit.Test;

public class TesteClienteTest {

    @Test
    public void testClasseCliente() {
        TesteCliente cli = new TesteCliente();
        cli.adicionarNome("Arthur");

        Assert.assertEquals("Arthur", cli.getNome());
    }
}
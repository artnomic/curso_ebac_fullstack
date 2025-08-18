import br.com.artnomic.TesteCliente;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TesteClienteTest {

    @Test
    public void testClasseCliente() {
        TesteCliente cli = new TesteCliente();
        cli.adicionarNome("Arthur");

        Assert.assertEquals("Arthur", cli.getNome());
    }
}
import br.com.artnomic.exercicio.Pessoa;
import br.com.artnomic.exercicio.SepararPorSexo;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TestaNomeFemininoTest {

    @Test
    public void testeNomeFeminino() {
        SepararPorSexo separador = new SepararPorSexo();
        Pessoa mulher1 = new Pessoa("Ana", "F");
        Pessoa mulher2 = new Pessoa("Beatriz", "f");
        Pessoa homem1 = new Pessoa("Carlos", "M");
        Pessoa homem2 = new Pessoa("Daniel", "m");
        List<Pessoa> listaDeEntrada = Arrays.asList(mulher1, homem1, mulher2, homem2);

        List<Pessoa> listaResultado = separador.filtrarMulheres(listaDeEntrada);

        assertEquals("A lista de mulheres deveria conter 2 pessoas.", 2, listaResultado.size());

        assertTrue("A lista de mulheres deveria conter a Ana.", listaResultado.contains(mulher1));

        assertTrue("A lista de mulheres deveria conter a Beatriz.", listaResultado.contains(mulher2));

        assertFalse("A lista de mulheres não deveria conter o Carlos.", listaResultado.contains(homem1));
    }
}

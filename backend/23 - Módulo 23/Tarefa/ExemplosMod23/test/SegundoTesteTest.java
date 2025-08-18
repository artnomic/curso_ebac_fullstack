import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SegundoTesteTest {

    @Test
    public void segundoTest() {
            String nome = "Arthur";
            Assert.assertEquals("Arthur", nome);
    }

    @Test
    public void testNotEquals() {
            String nome = "Art";
            Assert.assertNotEquals("Arthur", nome);
    }

    @Test
    public void testSegundoTest() {
    }

    @Test
    public void testNotEquals1() {
    }
}
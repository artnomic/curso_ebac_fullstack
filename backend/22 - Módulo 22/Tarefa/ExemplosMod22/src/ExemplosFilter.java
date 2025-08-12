import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ExemplosFilter {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoa();
        Stream <Pessoa> stream = lista.stream().filter(pessoa -> pessoa.getNacionalidade().equals("brasil"));

        Predicate<Pessoa> pred = pessoa -> pessoa.getNacionalidade().equals("brasil");
    }
}

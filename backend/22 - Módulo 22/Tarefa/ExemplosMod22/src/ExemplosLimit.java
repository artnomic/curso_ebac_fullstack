import java.util.List;
import java.util.stream.Stream;

public class ExemplosLimit {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoa();

        Stream<Pessoa> stream = lista.stream().limit(2);
    }
}

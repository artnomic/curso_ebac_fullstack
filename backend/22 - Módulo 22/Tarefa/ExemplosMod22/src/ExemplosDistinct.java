import java.util.List;
import java.util.stream.Stream;

public class ExemplosDistinct {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoa();

        Stream<Pessoa> stream = lista.stream().distinct();
    }
}

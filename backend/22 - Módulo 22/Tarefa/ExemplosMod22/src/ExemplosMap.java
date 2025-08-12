import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ExemplosMap {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoa();

        Stream<String> streamStr = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("brasil"))
                .map(Pessoa::getNome);

        IntStream streamInt = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("brasil"))
                .mapToInt(Pessoa::getIdade);
    }
}

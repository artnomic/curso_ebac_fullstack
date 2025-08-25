import java.util.List;
import java.util.stream.Collectors;

public class ExemplosCollect {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoa();

        List<Pessoa> listaBrasil = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("brasil"))
                .collect(Collectors.toList());

        listaBrasil.forEach(System.out::println);
    }
}

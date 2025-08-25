import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ExemplosOptional {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoa();

        Optional<Pessoa> opc = lista.stream()
                .max(Comparator.comparing(Pessoa::getIdade));

        if (opc.isPresent()) {
            System.out.println(opc.get());
        }
    }
}

import java.util.List;

public class ExemplosCount {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoa();

        long count = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Portugal"))
                .count();

        System.out.println(count);
    }
}

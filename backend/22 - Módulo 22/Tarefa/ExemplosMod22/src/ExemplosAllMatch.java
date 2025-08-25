import java.util.List;

public class ExemplosAllMatch {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoa();

       boolean result = lista.stream()
                .allMatch(pessoa -> pessoa.getNome().startsWith("A"));

       System.out.println(result);
    }
}

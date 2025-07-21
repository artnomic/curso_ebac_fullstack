import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Arthur");
        list.add("1");
        imprimir(list);

        List<Long> lista = new ArrayList<>();
        lista.add(1L);
        lista.add(3L);
        imprimir(lista);

        String primeiroSt = pegarPrimeiroLista(list);
        System.out.println(primeiroSt);

        Long primeiroL = pegarPrimeiroLista(lista);
        System.out.println(primeiroL);
    }

//    private static void imprimir(List<Object> obj) {
//        for (Object st : obj) {
//            System.out.println(st);
//        }
//    }
//
    public static <T> void imprimir(List<T> obj) {
        for (T o : obj) {
            System.out.println(o);
        }
    }

    public static <T> T pegarPrimeiroLista(List<T> list) {
        return list.get(0);
    }
}
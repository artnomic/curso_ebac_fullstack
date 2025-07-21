package generic;

public class ExemplosGenericEntry {
    public static void main(String[] args) {
        GenericEntry<String> entry = new GenericEntry<>("Teste");
        System.out.println(entry.getData());
    }
}

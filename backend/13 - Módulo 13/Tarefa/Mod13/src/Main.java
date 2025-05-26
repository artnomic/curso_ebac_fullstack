import br.com.artnomic.Abstrata.PessoaFisica;
import br.com.artnomic.Abstrata.PessoaJuridica;
import br.com.artnomic.CanetaEsferografica;
import br.com.artnomic.Giz;
import br.com.artnomic.Interfaces.ICaneta;
import br.com.artnomic.Lapis;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
//    public static void main(String[] args) {
//        ICaneta caneta = new CanetaEsferografica();
//        caneta.escrever("Olá Art!");
//        caneta.getCor();
//
//        ICaneta giz = new Giz();
//        giz.escrever("Hello Art!");
//        giz.getCor();
//
//        ICaneta lapis = new Lapis();
//        lapis.escrever("Hola Art!");
//        lapis.getCor();
//    }

    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica();
        pf.setCpf("450.183.538-99");
        pf.setNome("Arthur P. T. Berson");
        pf.setNatureza("Física");
        pf.setRenda(48000d);

        PessoaJuridica pj = new PessoaJuridica();
        pj.setCnpj("24.934.106/0001-20");
        pj.setNome("idwall");
        pj.setRenda(50000000);
        pj.setNatureza("Jurídica");
        pj.setPorte("LTDA");

        System.out.println(pf);
        System.out.println(pj);
    }
}

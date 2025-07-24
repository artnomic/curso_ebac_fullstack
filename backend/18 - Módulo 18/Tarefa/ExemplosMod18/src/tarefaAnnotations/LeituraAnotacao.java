package tarefaAnnotations;

import java.lang.annotation.Annotation;

public class LeituraAnotacao {

    public static void main(String[] args) {
        Class<TesteAnotacao> classe = TesteAnotacao.class;

        if (classe.isAnnotationPresent(Tabela.class)) {
            Tabela anotacaoTabela = classe.getAnnotation(Tabela.class);

            System.out.println("Nome da Tabela: " + anotacaoTabela.value());
        } else {
            System.out.println("A anotação @Tabela não está presente na classe TesteAnotacao.");
        }
    }
}
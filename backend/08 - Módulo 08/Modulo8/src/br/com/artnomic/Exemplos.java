/**
 * @author arthur.berson
 */
package br.com.artnomic;

public class Exemplos {
    private int codigo;
    private long codigoMaio;
    private double valorDecimal;
    private String texto;
    private boolean status;


    private float valorDecimal1;
    private short shor;
    private byte bi;

    public int retornaInteiro() {
        int val = 10;
        return this.codigo + val;
    }

    public int infereVal() {
        // Perceba que "val" não existe nesse contexto
//        this.val = 10;
        return 10;
    }
}

package br.com.artnomic.Abstrata;

public class PessoaFisica extends Pessoa {
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void DeclararImposto() {
        System.out.println("O imposto para a pessoa Física foi declarado por conta da renda de R$: " + getRenda());
    }
}

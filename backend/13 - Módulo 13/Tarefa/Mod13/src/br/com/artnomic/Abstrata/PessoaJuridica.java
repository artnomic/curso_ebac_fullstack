package br.com.artnomic.Abstrata;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String porte;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    @Override
    public void DeclararImposto() {
        System.out.println("O imposto para a pessoa Jurídica foi declarado por conta da renda de R$: " + getRenda());
    }
}

package br.com.artnomic.facade;

public class ApartamentoService implements IApartamentoService {

    @Override
    public Boolean cadastrarApartamento(Apartamento apartamento) {
        Boolean isCadastrado = isApartamentoCadastrado(apartamento);
        Boolean isValido = isCamposValidos(apartamento);

        if (isCadastrado && !isValido) {
            return false;
        }

        return cadastrarNoBanco();
    }

    private Boolean cadastrarNoBanco() {
        return true;
    }

    private Boolean isApartamentoCadastrado(Apartamento apartamento) {
        return false;
    }

    private Boolean isCamposValidos(Apartamento apartamento) {
        return true;
    }
}

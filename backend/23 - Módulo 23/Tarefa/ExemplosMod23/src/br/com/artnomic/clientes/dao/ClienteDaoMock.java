package br.com.artnomic.clientes.dao;

public class ClienteDaoMock implements IClienteDao {

    @Override
    public String salvar() {
        return "Salvar";
    }

}

package cadastro.dao;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arthur.berson
 */


import cadastro.dao.generic.GenericDAO;
import cadastro.domain.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO extends GenericDAO<Cliente> implements IClienteDAO {

    public ClienteMapDAO() {
        super();
        Map<Long, Cliente> mapaInterno = this.map.get(getTipoClasse());
        if (mapaInterno == null) {
            mapaInterno = new HashMap<>();
            this.map.put(getTipoClasse(), mapaInterno);
        }
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
            entityCadastrado.setNome(entity.getNome());
            entityCadastrado.setTel(entity.getTel());
            entityCadastrado.setNumero(entity.getNumero());
            entityCadastrado.setEndereco(entity.getEndereco());
            entityCadastrado.setCidade(entity.getCidade());
            entityCadastrado.setEstado(entity.getEstado());
    }
}

//    private Map<String, Cliente> map;
//
//    public ClienteMapDAO() {
//        this.map = new HashMap<>();
//    }
//
//    @Override
//    public Boolean cadastrar(Cliente cliente) {
//        if (this.map.containsKey(cliente.getCpf())) {
//            return false;
//        }
//
//        this.map.put(cliente.getCpf(), cliente);
//        return true;
//    }
//
//    @Override
//    public void excluir(String cpf) {
//        Cliente clienteCadastrado = this.map.get(cpf);
//
//        if (clienteCadastrado != null) {
//            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
//        }
//    }
//
//    @Override
//    public void alterar(Cliente cliente) {
//        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
//
//        if (clienteCadastrado != null) {
//            clienteCadastrado.setNome(cliente.getNome());
//            clienteCadastrado.setTel(cliente.getTel());
//            clienteCadastrado.setNumero(cliente.getNumero());
//            clienteCadastrado.setEndereco(cliente.getEndereco());
//            clienteCadastrado.setCidade(cliente.getCidade());
//            clienteCadastrado.setEstado(cliente.getEstado());
//        }
//    }
//
//    @Override
//    public Cliente consultar(String cpf) {
//        return this.map.get(cpf);
//    }
//
//    @Override
//    public Collection<Cliente> buscarTodos() {
//        return this.map.values();
//    }

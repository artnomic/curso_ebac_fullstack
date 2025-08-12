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

public class ClienteSetDAO extends GenericDAO<Cliente> implements IClienteDAO {

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


//    private Set<Cliente> set;
//
//    public ClienteSetDAO() {
//        this.set = new HashSet<>();
//    }
//
//    @Override
//    public Boolean cadastrar(Cliente cliente) {
//        return this.set.add(cliente);
//    }
//
//    @Override
//    public void excluir(String cpf) {
//        Cliente clienteEncontrado = null;
//        for (Cliente cliente : this.set) {
//            if(cliente.getCpf().equals(cpf)) {
//                clienteEncontrado = cliente;
//                break;
//            }
//        }
//
//        if (clienteEncontrado != null) {
//            this.set.remove(clienteEncontrado);
//        }
//    }
//
//    @Override
//    public void alterar(Cliente cliente) {
//        if (this.set.contains(cliente)) {
//            for (Cliente clienteCadastrado : this.set) {
//                if (clienteCadastrado.equals(cliente)) {
//                    clienteCadastrado.setNome(cliente.getNome());
//                    clienteCadastrado.setTel(cliente.getTel());
//                    clienteCadastrado.setNumero(cliente.getNumero());
//                    clienteCadastrado.setEndereco(cliente.getEndereco());
//                    clienteCadastrado.setCidade(cliente.getCidade());
//                    clienteCadastrado.setEstado(cliente.getEstado());
//                    break;
//                }
//            }
//        }
//    }
//
//    @Override
//    public Cliente consultar(String cpf) {
//        for (Cliente clienteCadastrado : this.set) {
//            if (clienteCadastrado.getCpf().equals(cpf)) {
//                return clienteCadastrado;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Collection<Cliente> buscarTodos() {
//        return this.set;
//    }
}

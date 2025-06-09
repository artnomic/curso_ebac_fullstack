/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastrojpanel.dao;

/**
 *
 * @author arthur.berson
 */

import cadastrojpanel.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {
    public Boolean cadastrar(Cliente cliente);

    public void excluir(String cpf);

    public void alterar(Cliente cliente);

    public Cliente consultar(String cpf);

    public Collection<Cliente> buscarTodos();
}

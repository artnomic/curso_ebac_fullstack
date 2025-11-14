package br.com.artnomic.vendas.online.servicoclientes.dto;

import br.com.artnomic.vendas.online.servicoclientes.Cliente;

public record PerfilClienteDTO(Cliente cliente, ProdutoDTO produtoFavorito) {
}

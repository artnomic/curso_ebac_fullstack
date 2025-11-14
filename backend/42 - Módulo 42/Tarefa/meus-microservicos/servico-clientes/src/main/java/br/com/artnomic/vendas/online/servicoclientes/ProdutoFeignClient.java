package br.com.artnomic.vendas.online.servicoclientes;

import br.com.artnomic.vendas.online.servicoclientes.dto.ProdutoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;


@FeignClient(name = "servico-produtos", url = "http://localhost:8081")
public interface ProdutoFeignClient {

    @GetMapping("/produtos/{id}")
    ProdutoDTO getProdutoById(@PathVariable("id") Long id);

     @GetMapping("/produtos")
     Collection<ProdutoDTO> getTodosOsProdutos();
}
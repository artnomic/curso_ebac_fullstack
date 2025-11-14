package br.com.artnomic.vendas.online.servicoprodutos;

import org.springframework.web.bind.annotation.*;
import jakarta.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private Map<Long, Produto> produtosDB = new ConcurrentHashMap<>();
    private AtomicLong idCounter = new AtomicLong(0);

    @PostConstruct
    private void carregarDadosIniciais() {
        salvarProduto(new Produto(null, "Notebook Gamer", 4500.00));
        salvarProduto(new Produto(null, "Mouse Óptico", 150.00));
    }

    private Produto salvarProduto(Produto produto) {
        if (produto.id() == null) {
            long id = idCounter.incrementAndGet();
            produto = new Produto(id, produto.nome(), produto.preco());
        }
        produtosDB.put(produto.id(), produto);
        return produto;
    }

    @GetMapping
    public Collection<Produto> buscarTodos() {
        return produtosDB.values();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtosDB.get(id);
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return salvarProduto(produto);
    }
}
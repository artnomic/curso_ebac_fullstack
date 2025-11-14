package br.com.artnomic.vendas.online.servicoclientes;

import br.com.artnomic.vendas.online.servicoclientes.dto.PerfilClienteDTO;
import br.com.artnomic.vendas.online.servicoclientes.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.PostConstruct;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private Map<Long, Cliente> clientesDB = new ConcurrentHashMap<>();
    private AtomicLong idCounter = new AtomicLong(0);

    @PostConstruct
    private void carregarDadosIniciais() {
        salvarCliente(new Cliente(null, "Ana Silva", "ana@email.com", 2L));
        salvarCliente(new Cliente(null, "Bruno Costa", "bruno@email.com", 1L));
    }

    private Cliente salvarCliente(Cliente cliente) {
        if (cliente.id() == null) {
            long id = idCounter.incrementAndGet();
            cliente = new Cliente(id, cliente.nome(), cliente.email(), cliente.idProdutoFavorito());
        }
        clientesDB.put(cliente.id(), cliente);
        return cliente;
    }

    @GetMapping
    public Collection<Cliente> buscarTodos() {
        return clientesDB.values();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clientesDB.get(id);
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return salvarCliente(cliente);
    }

    @Autowired
    private ProdutoFeignClient produtoFeignClient;

    @GetMapping("/{id}/perfil-completo")
    public PerfilClienteDTO getPerfilCompleto(@PathVariable Long id) {
        Cliente cliente = clientesDB.get(id);

        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado"); // Trate o erro
        }

        System.out.println("Chamando servico-produtos na porta 8081...");
        ProdutoDTO produto = produtoFeignClient.getProdutoById(cliente.idProdutoFavorito());

        return new PerfilClienteDTO(cliente, produto);
    }
}
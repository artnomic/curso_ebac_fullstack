package main.java.br.com.artnomic.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "modelo", length = 100, nullable = false)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "id_marca_fk")
    private Marca marca;

    @ManyToMany
    @JoinTable(name = "tb_carro_acessorio",
            joinColumns = @JoinColumn(name = "id_carro_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_acessorio_fk"))
    private List<Acessorio> acessorios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
}

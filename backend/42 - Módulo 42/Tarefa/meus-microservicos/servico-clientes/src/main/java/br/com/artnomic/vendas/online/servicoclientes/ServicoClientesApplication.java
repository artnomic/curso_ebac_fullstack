package br.com.artnomic.vendas.online.servicoclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServicoClientesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicoClientesApplication.class, args);
    }
}

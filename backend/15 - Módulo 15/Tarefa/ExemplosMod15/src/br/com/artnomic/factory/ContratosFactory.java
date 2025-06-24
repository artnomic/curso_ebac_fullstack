package br.com.artnomic.factory;

public class ContratosFactory extends Factory {

    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new CorolaCar(100, "Gasolina", "Azul-Marinho");
        } else {
            return new TCrossCar(120, "Eletricidade", "Cinza");
        }
    }
}

package br.com.artnomic.factory;

public class SemContratosFactory extends Factory {

    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new TCrossCar(100, "Gasolina", "Azul-Marinho");
        } else {
            return new CorolaCar(120, "Eletricidade", "Cinza");
        }
    }
}

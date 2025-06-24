package br.com.artnomic.factory;

public abstract class Car {

    private int horsePower;
    private String fuelSource;
    private String color;

    public Car(int horsePower, String fuelSource, String color) {
        this.horsePower = horsePower;
        this.fuelSource = fuelSource;
        this.color = color;
    }

    public void startEngine() {
        System.out.println("Ligando os Motores! A fonte de combustível é " + fuelSource + " e a potência do motor é de " + horsePower + " cavalos!");
    }

    public void clean () {
        System.out.println("O carro está limpo! E a cor " + color.toLowerCase() + " está brilhante!");
    }

    public void mechanicCheck() {
        System.out.println("O carro foi revisado, está tudo ok!");
    }

    public void fuelCar() {
        System.out.println("O carro está abastecido com " + fuelSource.toLowerCase());
    }
}

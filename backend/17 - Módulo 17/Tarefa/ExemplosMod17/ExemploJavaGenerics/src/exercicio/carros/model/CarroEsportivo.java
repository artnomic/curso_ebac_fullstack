package exercicio.carros.model;

public class CarroEsportivo extends Carro {
    private int potenciaHP;

    public CarroEsportivo(String marca, String modelo, int ano, String cor, int potenciaHP) {
        super(marca, modelo, ano, cor);
        this.potenciaHP = potenciaHP;
    }

    public int getPotenciaHP() {
        return potenciaHP;
    }

    @Override
    public String descreverTipo() {
        return "Carro Esportivo";
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + descreverTipo() + ", Potência: " + potenciaHP + " HP";
    }
}

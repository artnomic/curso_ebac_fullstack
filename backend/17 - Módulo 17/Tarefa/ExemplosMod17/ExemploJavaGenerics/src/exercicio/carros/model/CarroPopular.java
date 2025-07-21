package exercicio.carros.model;

public class CarroPopular  extends Carro {
    private int numeroPortas;

    public CarroPopular(String marca, String modelo, int ano, String cor, int numeroPortas) {
        super(marca, modelo, ano, cor);
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    @Override
    public String descreverTipo() {
        return "Carro Popular";
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + descreverTipo() + ", Portas: " + numeroPortas;
    }
}

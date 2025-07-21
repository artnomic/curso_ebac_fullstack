package exercicio.carros.model;

public class CarroSUV extends Carro {
    private boolean tracao4x4;

    public CarroSUV(String marca, String modelo, int ano, String cor, boolean tracao4x4) {
        super(marca, modelo, ano, cor);
        this.tracao4x4 = tracao4x4;
    }

    public boolean isTracao4x4() {
        return tracao4x4;
    }

    @Override
    public String descreverTipo() {
        return "Carro SUV";
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + descreverTipo() + ", Tração 4x4: " + (tracao4x4 ? "Sim" : "Não");
    }
}

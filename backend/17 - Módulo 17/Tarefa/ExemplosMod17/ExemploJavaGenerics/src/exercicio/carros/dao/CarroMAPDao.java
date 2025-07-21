package exercicio.carros.dao;


import exercicio.carros.model.Carro;

public class CarroMAPDao extends GenericDAO<Carro, String> implements ICarroMAPDao {

    @Override
    public void adicionar(Carro carro) {
        put(carro.getModelo(), carro);
        System.out.println("Carro '" + carro.getModelo() + "' adicionado com sucesso!");
    }

    @Override
    public void atualizar(Carro carro) {
        if (buscarPorId(carro.getModelo()) != null) {
            put(carro.getModelo(), carro);
            System.out.println("Carro '" + carro.getModelo() + "' atualizado com sucesso!");
        } else {
            System.out.println("Carro '" + carro.getModelo() + "' não encontrado para atualização.");
        }
    }
}

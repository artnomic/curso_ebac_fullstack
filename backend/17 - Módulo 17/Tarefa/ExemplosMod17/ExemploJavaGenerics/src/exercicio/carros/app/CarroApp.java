package exercicio.carros.app;

import javax.swing.JOptionPane;
import java.util.List;

import exercicio.carros.dao.CarroMAPDao;
import exercicio.carros.dao.ICarroMAPDao;
import exercicio.carros.model.Carro;
import exercicio.carros.model.CarroEsportivo;
import exercicio.carros.model.CarroPopular;
import exercicio.carros.model.CarroSUV;


public class CarroApp {
    private static ICarroMAPDao carroDao = new CarroMAPDao();

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Adicionar Carro", "Listar Carros", "Buscar Carro", "Atualizar Carro", "Remover Carro", "Sair"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Fábrica de Carros",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0:
                    adicionarNovoCarro();
                    break;
                case 1:
                    listarCarros();
                    break;
                case 2:
                    buscarCarro();
                    break;
                case 3:
                    atualizarCarro();
                    break;
                case 4:
                    removerCarro();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo da Fábrica de Carros. Até mais!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Operação cancelada. Saindo da Fábrica de Carros.");
                    return;
            }
        }
    }

    private static void adicionarNovoCarro() {
        String[] tipoCarroOptions = {"Esportivo", "Popular", "SUV"};
        int tipoChoice = JOptionPane.showOptionDialog(
                null,
                "Qual tipo de carro você deseja adicionar?",
                "Tipo de Carro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipoCarroOptions,
                tipoCarroOptions[0]
        );

        if (tipoChoice == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String marca = JOptionPane.showInputDialog("Digite a marca do carro:");
        if (marca == null) return;
        String modelo = JOptionPane.showInputDialog("Digite o modelo do carro:");
        if (modelo == null) return;
        String anoStr = JOptionPane.showInputDialog("Digite o ano do carro:");
        if (anoStr == null) return;
        int ano = 0;
        try {
            ano = Integer.parseInt(anoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ano inválido. Por favor, digite um número.");
            return;
        }
        String cor = JOptionPane.showInputDialog("Digite a cor do carro:");
        if (cor == null) return;

        Carro novoCarro = null;
        switch (tipoChoice) {
            case 0:
                String potenciaStr = JOptionPane.showInputDialog("Digite a potência (HP) do carro esportivo:");
                if (potenciaStr == null) return;
                int potencia = 0;
                try {
                    potencia = Integer.parseInt(potenciaStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Potência inválida. Por favor, digite um número.");
                    return;
                }
                novoCarro = new CarroEsportivo(marca, modelo, ano, cor, potencia);
                break;
            case 1:
                String portasStr = JOptionPane.showInputDialog("Digite o número de portas do carro popular:");
                if (portasStr == null) return;
                int portas = 0;
                try {
                    portas = Integer.parseInt(portasStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Número de portas inválido. Por favor, digite um número.");
                    return;
                }
                novoCarro = new CarroPopular(marca, modelo, ano, cor, portas);
                break;
            case 2:
                int tracaoChoice = JOptionPane.showConfirmDialog(null, "O SUV possui tração 4x4?", "Tração 4x4", JOptionPane.YES_NO_OPTION);
                boolean tracao4x4 = (tracaoChoice == JOptionPane.YES_OPTION);
                novoCarro = new CarroSUV(marca, modelo, ano, cor, tracao4x4);
                break;
        }

        if (novoCarro != null) {
            carroDao.adicionar(novoCarro);
            JOptionPane.showMessageDialog(null, "Carro adicionado com sucesso!\n" + novoCarro.toString());
        }
    }

    private static void listarCarros() {
        List<Carro> carros = carroDao.buscarTodos();
        if (carros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro cadastrado ainda.");
            return;
        }

        StringBuilder sb = new StringBuilder("Carros Cadastrados:\n\n");
        for (Carro carro : carros) {
            sb.append(carro.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void buscarCarro() {
        String modelo = JOptionPane.showInputDialog("Digite o modelo do carro para buscar:");
        if (modelo == null || modelo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Modelo não pode ser vazio.");
            return;
        }
        Carro carro = carroDao.buscarPorId(modelo);
        if (carro != null) {
            JOptionPane.showMessageDialog(null, "Carro encontrado:\n" + carro.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Carro com modelo '" + modelo + "' não encontrado.");
        }
    }

    private static void atualizarCarro() {
        String modeloAntigo = JOptionPane.showInputDialog("Digite o modelo do carro que deseja atualizar:");
        if (modeloAntigo == null || modeloAntigo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Modelo não pode ser vazio.");
            return;
        }

        Carro carroExistente = carroDao.buscarPorId(modeloAntigo);
        if (carroExistente == null) {
            JOptionPane.showMessageDialog(null, "Carro com modelo '" + modeloAntigo + "' não encontrado para atualização.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Carro encontrado para atualização:\n" + carroExistente.toString());

        String marca = JOptionPane.showInputDialog("Nova marca (deixe em branco para manter '" + carroExistente.getMarca() + "'):");
        if (marca == null) return;
        if (marca.trim().isEmpty()) marca = carroExistente.getMarca();

        String modeloNovo = JOptionPane.showInputDialog("Novo modelo (deixe em branco para manter '" + carroExistente.getModelo() + "'):");
        if (modeloNovo == null) return;
        if (modeloNovo.trim().isEmpty()) modeloNovo = carroExistente.getModelo();

        String anoStr = JOptionPane.showInputDialog("Novo ano (deixe em branco para manter '" + carroExistente.getAno() + "'):");
        if (anoStr == null) return;
        int ano = carroExistente.getAno();
        if (!anoStr.trim().isEmpty()) {
            try {
                ano = Integer.parseInt(anoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ano inválido. Mantendo o ano original.");
            }
        }

        String cor = JOptionPane.showInputDialog("Nova cor (deixe em branco para manter '" + carroExistente.getCor() + "'):");
        if (cor == null) return;
        if (cor.trim().isEmpty()) cor = carroExistente.getCor();

        Carro carroAtualizado = null;
        if (carroExistente instanceof CarroEsportivo) {
            String potenciaStr = JOptionPane.showInputDialog("Nova potência (HP) (deixe em branco para manter '" + ((CarroEsportivo) carroExistente).getPotenciaHP() + "'):");
            if (potenciaStr == null) return;
            int potencia = ((CarroEsportivo) carroExistente).getPotenciaHP();
            if (!potenciaStr.trim().isEmpty()) {
                try {
                    potencia = Integer.parseInt(potenciaStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Potência inválida. Mantendo a potência original.");
                }
            }
            carroAtualizado = new CarroEsportivo(marca, modeloNovo, ano, cor, potencia);
        } else if (carroExistente instanceof CarroPopular) {
            String portasStr = JOptionPane.showInputDialog("Novo número de portas (deixe em branco para manter '" + ((CarroPopular) carroExistente).getNumeroPortas() + "'):");
            if (portasStr == null) return;
            int portas = ((CarroPopular) carroExistente).getNumeroPortas();
            if (!portasStr.trim().isEmpty()) {
                try {
                    portas = Integer.parseInt(portasStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Número de portas inválido. Mantendo o número de portas original.");
                }
            }
            carroAtualizado = new CarroPopular(marca, modeloNovo, ano, cor, portas);
        } else if (carroExistente instanceof CarroSUV) {
            int tracaoChoice = JOptionPane.showOptionDialog(null, "O SUV possui tração 4x4? (Sim para sim, Não para não)", "Tração 4x4", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sim", "Não"}, ((CarroSUV) carroExistente).isTracao4x4() ? "Sim" : "Não");
            boolean tracao4x4 = ((CarroSUV) carroExistente).isTracao4x4();
            if (tracaoChoice != JOptionPane.CLOSED_OPTION) {
                tracao4x4 = (tracaoChoice == JOptionPane.YES_OPTION);
            }
            carroAtualizado = new CarroSUV(marca, modeloNovo, ano, cor, tracao4x4);
        }

        if (carroAtualizado != null) {
            if (!modeloAntigo.equals(modeloNovo)) {
                carroDao.remover(modeloAntigo);
            }
            carroDao.atualizar(carroAtualizado);
            JOptionPane.showMessageDialog(null, "Carro atualizado com sucesso!\n" + carroAtualizado.toString());
        }
    }

    private static void removerCarro() {
        String modelo = JOptionPane.showInputDialog("Digite o modelo do carro para remover:");
        if (modelo == null || modelo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Modelo não pode ser vazio.");
            return;
        }
        Carro carro = carroDao.buscarPorId(modelo);
        if (carro != null) {
            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o carro:\n" + carro.toString(), "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                carroDao.remover(modelo);
                JOptionPane.showMessageDialog(null, "Carro '" + modelo + "' removido com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Carro com modelo '" + modelo + "' não encontrado.");
        }
    }
}

package cadastro;

import cadastro.dao.ClienteMapDAO;
import cadastro.dao.IClienteDAO;
import cadastro.domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair.",
                "Cadastro",
                JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção Inválida! \nDigite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair.",
                    "Green dinner",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();

            } else if (isOpcaoCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula, conforme o exemplo: \n\n" +
                                "Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);

            } else if (isOpcaoConsultar(opcao)) {
                Long dados = Long.valueOf(JOptionPane.showInputDialog(null,
                        "Digite o CPF: ",
                        "Consultar",
                        JOptionPane.INFORMATION_MESSAGE));
                consultar(dados);

            } else if (isOpcaoExcluir(opcao)) {
                Long dados = Long.valueOf(JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE));
                excluir(dados);
            } else {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair.",
                    "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void atualizar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        iClienteDAO.alterar(cliente);
    }

    private static void excluir(Long dados) {
        JOptionPane.showMessageDialog(null,
                "Cliente " + iClienteDAO.consultar(dados) + " excluido com sucesso! \n",
                "Excluido",
                JOptionPane.INFORMATION_MESSAGE);
        iClienteDAO.excluir(dados);
    }

    private static boolean isOpcaoExcluir(String opcao) {
        if ("3".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static void consultar(Long dados) {
        Cliente cliente = iClienteDAO.consultar(dados);

        if (cliente != null) {
            JOptionPane.showMessageDialog(null,
                    "Cliente encontrado: \n" +
                            cliente.toString(),
                    "Consultar",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null,
                "Cliente não encontrado!",
                "Consultar",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");

        Cliente cliente = new Cliente(dadosSeparados[0],
                dadosSeparados[1],
                dadosSeparados[2],
                dadosSeparados[3],
                dadosSeparados[4],
                dadosSeparados[5],
                dadosSeparados[6]);

        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

        if (isCadastrado) {
            JOptionPane.showMessageDialog(null,
                    "Cliente cadastrado com sucesso",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Cliente já cadastrado",
                    "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static boolean isOpcaoConsultar(String opcao) {
        if ("2".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }

        return false;
    }
}
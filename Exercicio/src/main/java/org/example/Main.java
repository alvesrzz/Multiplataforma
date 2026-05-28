package org.example;

import org.example.DAO.EmpresaDAO;
import org.example.DAO.FuncionarioDAO;
import org.example.model.Empresa;
import org.example.model.Funcionario;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EmpresaDAO empresaDAO = new EmpresaDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        int opcao;

        do {

            String menu = """
                    1 - Cadastrar empresa
                    2 - Cadastrar funcionário
                    3 - Consultar empresa
                    4 - Consultar funcionário
                    5 - Sair
                    
                    Escolha uma opção:
                    """;

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {

                case 1:

                    Empresa empresa = new Empresa();

                    empresa.setNome(
                            JOptionPane.showInputDialog("Digite o nome da empresa:")
                    );

                    empresa.setQtd_func(
                            Integer.parseInt(
                                    JOptionPane.showInputDialog("Digite a quantidade de funcionários:")
                            )
                    );

                    empresa.setEndereco(
                            JOptionPane.showInputDialog("Digite o endereço da empresa:")
                    );

                    empresaDAO.cadastrar(empresa);

                    break;
                case 2:
                    Funcionario funcionario = new Funcionario();

                    funcionario.setNome(
                            JOptionPane.showInputDialog("Digite o nome do funcionário:")
                    );

                    String dataTexto = JOptionPane.showInputDialog(
                            "Digite a data (AAAA-MM-DD):"
                    );

                    funcionario.setDataFuncionario(LocalDate.parse(dataTexto));

                    funcionario.setCod_emp(
                            Integer.parseInt(
                                    JOptionPane.showInputDialog("Digite o código da empresa:")
                            )
                    );

                    funcionarioDAO.cadastrar(funcionario);

                    break;

                case 3:
                    String nomeEmpresa = JOptionPane.showInputDialog(
                            "Digite o nome da empresa:"
                    );

                    empresaDAO.consultar(nomeEmpresa);

                    break;

                case 4:
                    String nomeFuncionario = JOptionPane.showInputDialog(
                            "Digite o nome do funcionário:"
                    );

                    funcionarioDAO.consultar(nomeFuncionario);

                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 5);
    }
}
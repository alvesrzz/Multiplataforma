package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();

        String nome = JOptionPane.showInputDialog("Digite o nome: ");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: "));
        Aluno aluno = new Aluno(nome,idade);
        alunoDAO.cadastrar(aluno);

        String paramQuery = JOptionPane.showInputDialog("Digite um nome para buscar: ");

        alunoDAO.consultar(paramQuery);
    }
}
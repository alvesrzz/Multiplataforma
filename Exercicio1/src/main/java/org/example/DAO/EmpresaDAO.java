package org.example.DAO;

import org.example.conexao.conexao;
import org.example.model.Empresa;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaDAO {
    public EmpresaDAO() {

    }
    public void cadastrar(Empresa empresa) {
        Connection conn = conexao.conectar();
        String sql = "insert into empresa(nome,qtd_func,endereco) values (?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, empresa.getNome());
            stmt.setInt(2, empresa.getQtd_func());
            stmt.setString(3, empresa.getEndereco());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog((Component)null, "Empresa cadastrada com sucesso");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((Component)null, "Erro: " + e.getMessage());
        }

    }
    public void consultar(String empresaBusca) {
        Connection conn = conexao.conectar();
        String sql = "select * from empresa";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, empresaBusca);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String var10000 = rs.getString("nome");
                String resultado = "Nome da Empresa: " + var10000 + "\nQuantidade de Funcionarios: " + rs.getInt("qtd_func")+ "\nEndereço: " + rs.getString("endereco");
                JOptionPane.showMessageDialog((Component)null, resultado);
            } else {
                JOptionPane.showMessageDialog((Component)null, "Empresa não encontrada");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((Component)null, "Erro: " + e.getMessage());
        }

    }
}

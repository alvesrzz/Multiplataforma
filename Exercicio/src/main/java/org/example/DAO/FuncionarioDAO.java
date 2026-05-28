package org.example.DAO;

import org.example.conexao.conexao;
import org.example.model.Funcionario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {
    public void cadastrar(Funcionario funcionario){
        Connection conn = conexao.conectar();
        String sql = "insert into funcionario(nome,data_nascimento,cod_emp) values (?,?,?)";

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,funcionario.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(funcionario.getDataFuncionario()));
            stmt.setInt(3,funcionario.getCod_emp());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null,"Funcionario cadastrado com sucesso");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage());
        }
    }

    public void consultar(String nomeBusca) {
        Connection conn = conexao.conectar();
        String sql = "select * from funcionario where nome = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,nomeBusca);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                String resultado =
                        "NOME: "+rs.getString("nome") +
                                "\nDATA: "+rs.getDate("data_nascimento")+
                                "\nCOD_EMP: "+rs.getInt("cod_emp");

                JOptionPane.showMessageDialog(null,resultado);
            } else {
                JOptionPane.showMessageDialog(null,"Empresa não encontrada");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage());
        }
    }
}
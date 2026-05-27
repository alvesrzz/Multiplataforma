package org.example.conexao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    public static Connection conectar(){
        try{
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/exercicio1",
                    "root",
                    ""
            );
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro na conexão!");
            return null;
        }
    }
}

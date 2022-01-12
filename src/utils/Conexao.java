/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author Fernando Marcos Rodrigues
 * Classe para conexão com banco de dados Postgres
 * Este Condigo fonte foi fornecido pelo professor Marcio Schoenfelder
 * 
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexao {
    
    public static Connection conectar(){
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/pubfuture";
        String user = "postgres";
        String password = "fe044159";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao conectar com o banco de dados");
        }
        return con;   
    }      
    public static void closeConnection(Connection connection){
        try {
           if (connection!=null) connection.close();
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao fechar com o banco de dados");
        }
    }
      
    public static void closeConnection(Connection connection, PreparedStatement pstm){
        try {
           if (pstm!=null) pstm.close();
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao fechar PreparedStatement");
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement pstm,ResultSet resultSet ){
        try {
           if (resultSet!=null) resultSet.close();
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao fechar PreparedStatement");
        }
    }
}

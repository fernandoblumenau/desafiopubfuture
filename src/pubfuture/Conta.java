/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pubfuture;

import java.sql.Connection;
import utils.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Fernando Marcos Rodrigues
 */
public class Conta {
    
    private int idConta;
    private String tipoConta;
    private String instFinanceira;
    private Double vlrSaldo;

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getInstFinanceira() {
        return instFinanceira;
    }

    public void setInstFinanceira(String instFinanceira) {
        this.instFinanceira = instFinanceira;
    }

    public Double getVlrSaldo() {
        return vlrSaldo;
    }

    public void setVlrSaldo(Double vlrSaldo) {
        this.vlrSaldo = vlrSaldo;
    }
    
 /**
 *
 * Metodos para classe Conta
 */

    public void cadastrarConta(Conta conta) {
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
     
        try {
            String sql = "INSERT INTO conta ("
                    + "idconta,"
                    + "tipoconta,"
                    + "instfinanceira,"
                    + "vlrsaldo) VALUES (?,?,?,?)";
            pstm = connection.prepareStatement(sql);
            
            pstm.setInt(1, this.idConta);
            pstm.setString(2, this.tipoConta);
            pstm.setString(3, this.instFinanceira);
            pstm.setDouble(4, this.vlrSaldo);
            
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Conta Criada",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"Erro ao inserir conta no banco",
                    "Erro",JOptionPane.ERROR_MESSAGE);            
        }     
        finally{
            Conexao.closeConnection(connection, pstm);
        }
    }

    public void editarConta(Conta conta) {
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        
        try {
            String sql = "UPDATE conta SET "
                    + "tipoconta=?, "
                    + "instfinanceira=?, "
                    + "vlrsaldo=? "
                    + "WHERE idconta=?";
            pstm = connection.prepareStatement(sql);
            
            pstm.setString(1, this.tipoConta);
            pstm.setString(2, this.instFinanceira);
            pstm.setDouble(3, this.getVlrSaldo());
            pstm.setInt(4, this.getIdConta());
            
            System.out.println(pstm);
            
            //pstm.execute();
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);            
                    
               
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados de conta"
                    + " no banco","Erro",
                    JOptionPane.ERROR_MESSAGE);   
        }  
        finally{
            Conexao.closeConnection(connection, pstm);
        }
     }

    public void removerConta(int idConta) {
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        
        try {
            String sql = "DELETE FROM conta WHERE idconta=?";
            pstm = connection.prepareStatement(sql);
            
            pstm.setInt(1, idConta);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Removido com Sucesso",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro ao Deleta conta no banco",
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }
        finally{
            Conexao.closeConnection(connection, pstm);
        }
    }

    public List<Conta> listarContas() {
        
        List<Conta> contas = new ArrayList<>();
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        ResultSet resultSet = null;
        
        try {
            String sql = "SELECT *FROM conta;";
            pstm = connection.prepareStatement(sql);    
            resultSet = pstm.executeQuery();
            
            while (resultSet.next()) { 
                
                Conta objConta = new Conta();
                objConta.setIdConta(resultSet.getInt("idConta"));
                objConta.setTipoConta(resultSet.getString("tipoConta"));
                objConta.setInstFinanceira(resultSet.getString("instFinanceira"));
                objConta.setVlrSaldo(resultSet.getDouble("vlrSaldo"));
                contas.add(objConta);         
            }
        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco",
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }  
        finally{
            Conexao.closeConnection(connection, pstm, resultSet);
        }
        return contas;
        // TODO implement here
    }

    public void transferirSaldo() {
        // TODO implement here
    }

    public void listarSaldo() {
        // TODO implement here
    }

    @Override
    public String toString() {
        return "Conta{" + "idConta="
                + idConta + ", tipoConta="
                + tipoConta + ", instFinanceira=" 
                + instFinanceira + ", vlrSaldo=" 
                + vlrSaldo + '}';
    }            
}

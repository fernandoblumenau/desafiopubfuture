/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pubfuture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utils.Conexao;

/**
 *
 * @author Fernando Marcos Rodrigues
 */
public class Despesa {
    
    
    private int idConta;
    private Date dataPagto;
    private String tipoDespesa;
    private Date dataPagtoEsperado;
    private Double vlrDespesa;

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public Date getDataPagto() {
        return dataPagto;
    }

    public void setDataPagto(Date dataPagto) {
        this.dataPagto = dataPagto;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    
      public Date getDataPagtoEsperado() {
        return dataPagtoEsperado;
    }

    public void setDataPagtoEsperado(Date dataPagtoEsperado) {
        this.dataPagtoEsperado = dataPagtoEsperado;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }
    
    

    public Double getVlrDespesa() {
        return vlrDespesa;
    }

    public void setVlrDespesa(Double vlrDespesa) {
        this.vlrDespesa = vlrDespesa;
    }
    
  
/**
 *
 * Metodos para classe Despesas
 */    

    public void cadastrarDespesa(Despesa despesa) {
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;

        try {
            String sql = "INSERT INTO despesa ("
                    + "idconta,"
                    + "datapagto,"
                    + "datapagtoesperado," 
                    + "tipodespesa,"                    
                    + "vlrdespesa) VALUES (?,?,?,?,?)";
            pstm = connection.prepareStatement(sql);
            
            System.out.println(sql);
            pstm.setInt(1, this.idConta);
            pstm.setDate(2, this.dataPagto);
            pstm.setDate(3, this.dataPagtoEsperado);
            pstm.setString(4, this.tipoDespesa);
            pstm.setDouble(5, this.vlrDespesa);            
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Despesa Criada",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"Erro ao inserir despesa no banco"+erro,
                    "Erro",JOptionPane.ERROR_MESSAGE);            
        }     
        finally{
            Conexao.closeConnection(connection, pstm);
        }   
    }

    public void editarDespesa(Despesa Despesas) {
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;

        try {
            String sql = "UPDATE despesa SET "
                    + "datapagto=?,"
                    + "datapagtoesperado=?," 
                    + "tipodespesa=?,"                    
                    + "vlrdespesa=?"
                    + "WHERE idconta = ?";
            pstm = connection.prepareStatement(sql);
            
            pstm.setDate(1, this.dataPagto);
            pstm.setDate(2, this.dataPagtoEsperado);
            pstm.setString(3, this.tipoDespesa);
            pstm.setDouble(4, this.vlrDespesa);
            pstm.setInt(5, this.idConta);
            pstm.execute();        
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);            
                    
               
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados de despesa"+erro
                    + " no banco","Erro",
                    JOptionPane.ERROR_MESSAGE);   
        }  
        finally{
            Conexao.closeConnection(connection, pstm);
        }        
    }

    public  void removerDespesa(int idConta) {
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        
        try {
            String sql = "DELETE FROM despesa WHERE idconta=?";
            pstm = connection.prepareStatement(sql);
            
            pstm.setInt(1, idConta);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Removido com Sucesso",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro ao Deleta Despesas no banco",
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }
        finally{
            Conexao.closeConnection(connection, pstm);
        }
    }

    public List<Despesa> listarDespesa() {
                
        List<Despesa> despesas = new ArrayList<>();
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        ResultSet resultSet = null;
        
        try {
            String sql = "SELECT *FROM despesa;";
            pstm = connection.prepareStatement(sql);    
            resultSet = pstm.executeQuery();
            
            while (resultSet.next()) { 
                
                Despesa objDespesa = new Despesa();
                objDespesa.setIdConta(resultSet.getInt("idConta"));
                objDespesa.setDataPagto(resultSet.getDate("datapagto"));
                objDespesa.setDataPagtoEsperado(resultSet.getDate("datapagtoesperado"));
                objDespesa.setTipoDespesa(resultSet.getString("tipodespesa"));
                objDespesa.setVlrDespesa(resultSet.getDouble("vlrdespesa"));
                despesas.add(objDespesa);         
            }
        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco"+erro,
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }  
        finally{
            Conexao.closeConnection(connection, pstm, resultSet);
        }
        return despesas;

    }

    public Double listarDespesaTotal() {
        Double despesa=0d;
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        ResultSet resultSet = null;
        
        try {
            String sql = "SELECT SUM(vlrdespesa)soma FROM despesa;";
            pstm = connection.prepareStatement(sql);    
            resultSet = pstm.executeQuery();
            resultSet.next();
            despesa=resultSet.getDouble("soma");

        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco"+erro,
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }  
        finally{
            Conexao.closeConnection(connection, pstm, resultSet);
        }
        return despesa;
        
    }

    @Override
    public String toString() {
        return "Despesa{" + "idConta=" + idConta + ", dataPagto=" + dataPagto + ", tipoDespesa=" + tipoDespesa + ", dataPagtoEsperado=" + dataPagtoEsperado + ", vlrDespesa=" + vlrDespesa + '}';
    }


    
    
}

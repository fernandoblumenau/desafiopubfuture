/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Controller.Conexao;

/**
 *
 * @author Fernando Marcos Rodrigues
 * Classe Java Com todos os metodos da entidade Receita
 */
public class Receita {
    
    private int idConta;
    private String tipoReceita;
    private Date dataRecebimento;
    private Date dataRecebEsperado;
    private Double vlrReceita;
    private String descReceita;

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(String tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    
    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getDataRecebEsperado() {
        return dataRecebEsperado;
    }

    public void setDataRecebEsperado(Date dataRecebEsperado) {
        this.dataRecebEsperado = dataRecebEsperado;
    }

    public Double getVlrReceita() {
        return vlrReceita;
    }

    public void setVlrReceita(Double vlrReceita) {
        this.vlrReceita = vlrReceita;
    }

    public String getDescReceita() {
        return descReceita;
    }

    public void setDescReceita(String descReceita) {
        this.descReceita = descReceita;
    }
           
/**
 *
 * Inicio da Declaração dos Metodos
 */

    public void cadastrarReceita(Receita receitas) {
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;

        try {
            String sql = "INSERT INTO receita ("
                    + "idconta,"
                    + "tiporeceita,"
                    + "datarecebimento," 
                    + "datarecebesperado," 
                    + "descreceita,"
                    + "vlrreceita) VALUES (?,?,?,?,?,?)";
            pstm = connection.prepareStatement(sql);
            
            System.out.println(sql);
            pstm.setInt(1, this.idConta);
            pstm.setString(2, this.tipoReceita);
            pstm.setDate(3, this.dataRecebimento);
            pstm.setDate(4, this.dataRecebEsperado);
            pstm.setString(5, this.descReceita);
            pstm.setDouble(6, this.vlrReceita);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Receita Criada",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"Erro ao inserir Receita no banco"+erro,
                    "Erro",JOptionPane.ERROR_MESSAGE);            
        }     
        finally{
            Conexao.closeConnection(connection, pstm);
        }   
    }

    public void editarReceita(Receita receitas) {
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;

        try {
            String sql = "UPDATE receita SET "
                    + "tiporeceita=?,"
                    + "datarecebimento=?," 
                    + "datarecebesperado=?,"                    
                    + "descreceita=?,"
                    + "vlrreceita=?"
                    + "WHERE idconta = ?";
            pstm = connection.prepareStatement(sql);
            
            System.out.println(this.descReceita);
            
            pstm.setString(1, this.tipoReceita);
            pstm.setDate(2, this.dataRecebimento);
            pstm.setDate(3, this.dataRecebEsperado);
            pstm.setString(4, this.descReceita);
            pstm.setDouble(5,vlrReceita);
            pstm.setInt(6, this.idConta);
            pstm.execute();        
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);                                               
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados de Receita"+erro
                    + " no banco","Erro",
                    JOptionPane.ERROR_MESSAGE);   
        }  
        finally{
            Conexao.closeConnection(connection, pstm);
        }        
    }

    public void removerReceita(int idconta) {
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        
        try {
            String sql = "DELETE FROM receita WHERE idconta=?";
            pstm = connection.prepareStatement(sql);
            
            pstm.setInt(1, idConta);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Removido com Sucesso",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro ao Deleta Receita no banco",
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }
        finally{
            Conexao.closeConnection(connection, pstm);
        }        
    }

    public List<Receita> listarReceita() {
               
        List<Receita> receita = new ArrayList<>();
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        ResultSet resultSet = null;
        
        try {
            String sql = "SELECT *FROM receita;";
            pstm = connection.prepareStatement(sql);    
            resultSet = pstm.executeQuery();
            
            while (resultSet.next()) { 
                
                Receita objReceita = new Receita();
                objReceita.setIdConta(resultSet.getInt("idConta"));                
                objReceita.setTipoReceita(resultSet.getString("tiporeceita"));
                objReceita.setDataRecebimento(resultSet.getDate("datarecebimento"));
                objReceita.setDataRecebEsperado(resultSet.getDate("datarecebesperado"));               
                objReceita.setDescReceita(resultSet.getString("descreceita"));
                objReceita.setVlrReceita(resultSet.getDouble("vlrreceita"));
                receita.add(objReceita);         
            }
        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco"+erro,
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }  
        finally{
            Conexao.closeConnection(connection, pstm, resultSet);
        }
        return receita; 
    }

    public Double listarReceitaTotal() {
        Double receita=0d;
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        ResultSet resultSet = null;
        
        try {
            String sql = "SELECT SUM(vlrreceita)soma FROM receita;";
            pstm = connection.prepareStatement(sql);    
            resultSet = pstm.executeQuery();
            resultSet.next();
            receita=resultSet.getDouble("soma");

        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco"+erro,
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }  
        finally{
            Conexao.closeConnection(connection, pstm, resultSet);
        }
        return receita;
    }        
}

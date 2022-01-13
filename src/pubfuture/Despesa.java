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

    public void editarDespesa() {
        // TODO implement here
    }

    public void removerDespesa() {
        // TODO implement here
    }

    public void listarDespesa() {
        // TODO implement here
    }

    public void listarDespesaTotal() {
        // TODO implement here
    }

    @Override
    public String toString() {
        return "Despesa{" + "idConta=" + idConta + ", dataPagto=" + dataPagto + ", tipoDespesa=" + tipoDespesa + ", dataPagtoEsperado=" + dataPagtoEsperado + ", vlrDespesa=" + vlrDespesa + '}';
    }
    
    
    
}

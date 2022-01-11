/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pubfuture;

import java.util.Date;

/**
 *
 * @author Fernando Marcos Rodrigues
 */
public class Despesa {
    
    
    private int idConta;
    private Date dataPagto;
    private Date dataPagtoEsperado;
    private String descTipoDespesa;
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

    public Date getDataPagtoEsperado() {
        return dataPagtoEsperado;
    }

    public void setDataPagtoEsperado(Date dataPagtoEsperado) {
        this.dataPagtoEsperado = dataPagtoEsperado;
    }

    public String getDescTipoDespesa() {
        return descTipoDespesa;
    }

    public void setDescTipoDespesa(String descTipoDespesa) {
        this.descTipoDespesa = descTipoDespesa;
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

    public void cadastrarDespesa() {
        // TODO implement here
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
    
}

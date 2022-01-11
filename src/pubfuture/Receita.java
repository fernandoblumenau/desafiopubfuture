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
public class Receita {
    
    private int idConta;
    private Date dataRecebimento;
    private String descTipoReceita;
    private Date dataRecebEsperado;
    private Double vlrReceita;
    private String descReceita;

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getDescTipoReceita() {
        return descTipoReceita;
    }

    public void setDescTipoReceita(String descTipoReceita) {
        this.descTipoReceita = descTipoReceita;
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
 * Metodos para classe Receitas
 */

    public void cadastrarReceita() {
        // TODO implement here
    }

    public void editarReceita() {
        // TODO implement here
    }

    public void removerReceita() {
        // TODO implement here
    }

    public void listarReceita() {
        // TODO implement here
    }

    public void listarReceitaTotal() {
        // TODO implement here
    }
    
    
}

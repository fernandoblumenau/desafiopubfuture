/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import View.CadastroConta;
import View.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando Marcos Rodrigues
 * Classe Principal/ Faz a Chamada da tela Principal do Sistema
 */
public class PubFuture {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try {
            Principal telaPrincipal = new Principal();
            telaPrincipal.setVisible(true);
        } catch (Exception e) {
             e.printStackTrace();
        }       
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pubfuture.Conta;
import utils.Conexao;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ferna
 */
public class CadastroConta extends javax.swing.JFrame {

    /**
     * Creates new form CadastroConta
     */
    public CadastroConta() {
        initComponents();
        CarregarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBase = new javax.swing.JPanel();
        jLabelIdConta = new javax.swing.JLabel();
        jLabelTipoConta = new javax.swing.JLabel();
        jLabelInstFinanceira = new javax.swing.JLabel();
        jLabelVlrSaldo = new javax.swing.JLabel();
        jTextFieldIdConta = new javax.swing.JTextField();
        jTextFieldTipoConta = new javax.swing.JTextField();
        jTextFieldInstFinanceira = new javax.swing.JTextField();
        jTextFieldVlrSaldo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonCadastrarConta = new javax.swing.JButton();
        jScrollPaneContas = new javax.swing.JScrollPane();
        jTableContas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Contas");

        jPanelBase.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro"));

        jLabelIdConta.setText("IdConta");

        jLabelTipoConta.setText("tipoConta");

        jLabelInstFinanceira.setText("instFinanceira");

        jLabelVlrSaldo.setText("vlrSaldo");

        jTextFieldIdConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdContaActionPerformed(evt);
            }
        });

        jTextFieldTipoConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTipoContaActionPerformed(evt);
            }
        });

        jButtonCadastrarConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/salvar.png"))); // NOI18N
        jButtonCadastrarConta.setText("Cadastrar");
        jButtonCadastrarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarContaActionPerformed(evt);
            }
        });

        jTableContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodConta", "TipoConta", "Instituição", "Saldo"
            }
        ));
        jScrollPaneContas.setViewportView(jTableContas);

        javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
        jPanelBase.setLayout(jPanelBaseLayout);
        jPanelBaseLayout.setHorizontalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBaseLayout.createSequentialGroup()
                        .addComponent(jScrollPaneContas, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelBaseLayout.createSequentialGroup()
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIdConta)
                            .addComponent(jLabelTipoConta)
                            .addComponent(jLabelInstFinanceira)
                            .addComponent(jLabelVlrSaldo))
                        .addGap(38, 38, 38)
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIdConta)
                            .addComponent(jTextFieldTipoConta, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(jTextFieldInstFinanceira)
                            .addComponent(jTextFieldVlrSaldo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCadastrarConta)
                        .addGap(43, 43, 43))))
        );
        jPanelBaseLayout.setVerticalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdConta)
                    .addComponent(jTextFieldIdConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrarConta))
                .addGap(18, 18, 18)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipoConta)
                    .addComponent(jTextFieldTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelInstFinanceira)
                    .addComponent(jTextFieldInstFinanceira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVlrSaldo)
                    .addComponent(jTextFieldVlrSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneContas, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarContaActionPerformed
        // TODO add your handling code here:
        Conta conta = new Conta();
        conta.setIdConta(Integer.parseInt(jTextFieldIdConta.getText()));
        conta.setInstFinanceira(jTextFieldInstFinanceira.getText());
        conta.setTipoConta(jTextFieldTipoConta.getText());
        conta.setVlrSaldo(Double.parseDouble(jTextFieldVlrSaldo.getText()));
        conta.cadastrarConta(conta);
        CarregarTabela();
        
    }//GEN-LAST:event_jButtonCadastrarContaActionPerformed

    private void jTextFieldIdContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdContaActionPerformed

    private void jTextFieldTipoContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTipoContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTipoContaActionPerformed

    private void CarregarTabela(){
        
        DefaultTableModel tabela = (DefaultTableModel) jTableContas.getModel();
        tabela.setNumRows(0);
        
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        ResultSet resultSet = null;
        
        try {
            String sql = "SELECT *FROM conta;";
            pstm = connection.prepareStatement(sql);    
            resultSet = pstm.executeQuery();
            
            while (resultSet.next()) { 
                
                tabela.addRow(new Object[]{
                    resultSet.getInt("idConta"),
                    resultSet.getString("tipoConta"),
                    resultSet.getString("instFinanceira"),
                    resultSet.getString("vlrSaldo")
                });
            }
        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro ao Carregar tabela",
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }  
        finally{
            Conexao.closeConnection(connection, pstm, resultSet);
        }

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarConta;
    private javax.swing.JLabel jLabelIdConta;
    private javax.swing.JLabel jLabelInstFinanceira;
    private javax.swing.JLabel jLabelTipoConta;
    private javax.swing.JLabel jLabelVlrSaldo;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JScrollPane jScrollPaneContas;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableContas;
    private javax.swing.JTextField jTextFieldIdConta;
    private javax.swing.JTextField jTextFieldInstFinanceira;
    private javax.swing.JTextField jTextFieldTipoConta;
    private javax.swing.JTextField jTextFieldVlrSaldo;
    // End of variables declaration//GEN-END:variables
}
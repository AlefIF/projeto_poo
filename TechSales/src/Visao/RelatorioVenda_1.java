/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.GeraRelatorio;

/**
 *
 * @author polo
 */
public class RelatorioVenda_1 extends javax.swing.JFrame {

    public RelatorioVenda_1() {
        initComponents();
        setSize(410, 240);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfDataInicio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfDataFinal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Interface gráfica/back2.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Exemplo Relatório");
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonImprimir.png"))); // NOI18N
        jButton1.setText("Gerar Relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 130, 140, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Escolha o período de venda:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 174, 17);
        getContentPane().add(tfDataInicio);
        tfDataInicio.setBounds(64, 68, 129, 20);

        jLabel2.setText("a:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(206, 71, 20, 14);
        getContentPane().add(tfDataFinal);
        tfDataFinal.setBounds(220, 70, 135, 20);

        jLabel3.setText("De:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(24, 71, 20, 14);

        jLabel6.setText("Insira as datas: YYYY-MM-DD");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 40, 190, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.sql.Date dataInicio = java.sql.Date.valueOf(String.valueOf(tfDataInicio.getText()));
        java.sql.Date dataFinal = java.sql.Date.valueOf(String.valueOf(tfDataFinal.getText()));
        /*
        try {
            //chama o método para dar início a geração do relatório passando o código do cliente como parâmetro
            GeraRelatorio2.geraRelatorioJogos(dataInicio, dataFinal);
        } catch (Exception x) {
        }  */
        String query = "Select joNome , sum(ivQtd)as \n"
                + " 'Quantidade vendida' from jogo join item_venda \n"
                + " join venda  where venData \n"
                + "BETWEEN " + "'" + dataInicio + "'" + " and " + "'" + dataFinal + "'" + " \n "
                + " and joCodigo = iv_joCodigo and iv_venCodigo = venCodigo \n "
                + " group by joNome order by sum(ivQtd)  desc limit 10; ";
        try {
            //passa o caminho onde o relatório esta no projeto - codigo compilado
            GeraRelatorio.gerarRelatorio(query, "./report/TopJogosPorPeriodo.jasper");
        } catch (Exception x) {
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioVenda_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioVenda_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioVenda_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioVenda_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioVenda_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField tfDataFinal;
    private javax.swing.JTextField tfDataInicio;
    // End of variables declaration//GEN-END:variables
}

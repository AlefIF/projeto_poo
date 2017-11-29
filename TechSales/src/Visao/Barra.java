/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.VendaControle;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Wayne
 */
public class Barra extends javax.swing.JFrame {
    
    private VendaControle cVenda = new VendaControle();

    /**
     * Creates new form Barra
     */
    public Barra() {
        initComponents();

    }

    // método dataset
    // que são os valores no qual serão expostos no gráfico
    // primeiro parametro = valor do gráfico
    // segundo parametro = referência da legenda
    // terceiro parametro = nome em baixo da barra (como é o mesmo, aparecerá apenas 1 centralizado)
    private CategoryDataset createDataset() {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Integer.parseInt(jTextField1.getText()), "Janeiro", "Mês");
        dataset.addValue(Integer.parseInt(jTextField2.getText()), "Fevereiro", "Mês");
        dataset.addValue(Integer.parseInt(jTextField3.getText()), "Março", "Mês");
        dataset.addValue(Integer.parseInt(jTextField4.getText()), "Abril", "Mês");
        dataset.addValue(Integer.parseInt(jTextField1.getText()), "Maio", "Mês");
        dataset.addValue(Integer.parseInt(jTextField2.getText()), "Junho", "Mês");
        dataset.addValue(Integer.parseInt(jTextField3.getText()), "Julho", "Mês");
        dataset.addValue(Integer.parseInt(jTextField4.getText()), "Agosto", "Mês");
        dataset.addValue(Integer.parseInt(jTextField1.getText()), "Setembro", "Mês");
        dataset.addValue(Integer.parseInt(jTextField2.getText()), "Outrubro", "Mês");
        dataset.addValue(Integer.parseInt(jTextField3.getText()), "Novenbro", "Mês");
        dataset.addValue(Integer.parseInt(jTextField4.getText()), "Dezembro", "Mês");
        return dataset;
    }

    // responsavel por criar o grafico
    // mais "importante"
    public void criaGrafico() {
        // aqui ele pega os valores que serão inseridos nele
        CategoryDataset cds = createDataset();
        String titulo = "Grafico - BARRA"; // título do grafico
        String eixoy = "Notas"; // string na lateral esquerda, referente aos valores (as notas)
        String txt_legenda = "Bimestres"; // titulo da legenda
        // ferramentas auxiliares, não utilizadas (redirecionamento de url, ponteiro em cima)
        boolean legenda = true;
        boolean tooltips = false;
        boolean urls = false;
        // setando o grafico como barras verticais 3d
        // responsável pelo tipo  de gráfico que você vai criar (ex: pizza, barras e etc)
        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        // aqui está setando a altura e a largura do gráfico, para o máximo
        // ou seja, ocupará todo o componente painel
        myChartPanel.setSize(jPanel1.getWidth(), jPanel1.getHeight());
        // tornando vísivel
        myChartPanel.setVisible(true);
        jPanel1.removeAll(); // remove tudo que está desenhado no painel
        jPanel1.add(myChartPanel); // adiciona o gráfico no painel
        jPanel1.revalidate(); // revalida a painel para uma nova exibição
        jPanel1.repaint(); // "desenha" novamente no painel  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfAno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gráfico de Barras");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(454, 222));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );

        jButton1.setText("Gerar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Ano:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try{
         String query = 
         "select venCodigo, ivQtd from venda, item_venda \n"+
         "where venCodigo=iv_venCodigo and year(+venData)="+tfAno.getText()+";";   
         cVenda.consultar(query);
         }catch(Exception e){
             
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
            java.util.logging.Logger.getLogger(Barra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfAno;
    // End of variables declaration//GEN-END:variables
}

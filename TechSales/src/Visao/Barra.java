/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.VendaControle;
import Modelo.GraficoBEAN;
import java.util.ArrayList;
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
    private ArrayList<GraficoBEAN> alG = new ArrayList<>();

    /**
     * Creates new form Barra
     */
    public Barra() {
        initComponents();
        setSize(400, 350);
        setResizable(false);

    }

    // método dataset
    // que são os valores no qual serão expostos no gráfico
    // primeiro parametro = valor do gráfico
    // segundo parametro = referência da legenda
    // terceiro parametro = nome em baixo da barra (como é o mesmo, aparecerá apenas 1 centralizado)
    private CategoryDataset createDataset(ArrayList<GraficoBEAN> a) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (GraficoBEAN gO : a) {
            if (Integer.parseInt(gO.getVenData().toString()) == 2017) {
                // dataset.addValue(gO.getQuantidade(), "Janeiro", "Mês");
            } else if (Integer.valueOf(gO.getVenData().toString()) == 2) {
                dataset.addValue(gO.getQuantidade(), "Fevereiro", "Mês");
            } else if (Integer.valueOf(gO.getVenData().toString()) == 3) {
                dataset.addValue(gO.getQuantidade(), "Março", "Mês");
            } else if (Integer.valueOf(gO.getVenData().toString()) == 4) {
                dataset.addValue(gO.getQuantidade(), "Abril", "Mês");
            } else if (Integer.valueOf(gO.getVenData().toString()) == 5) {
                dataset.addValue(gO.getQuantidade(), "Maio", "Mês");
            } else if (Integer.valueOf(gO.getVenData().toString()) == 6) {
                dataset.addValue(gO.getQuantidade(), "Junho", "Mês");
            } else if (Integer.valueOf(gO.getVenData().toString()) == 7) {
                dataset.addValue(gO.getQuantidade(), "Julho", "Mês");
            } else if (Integer.valueOf(gO.getVenData().toString()) == 8) {
                dataset.addValue(gO.getQuantidade(), "Agosto", "Mês");
            } else if (Integer.valueOf(gO.getVenData().toString()) == 9) {
                dataset.addValue(gO.getQuantidade(), "Setembro", "Mês");
            } else if (Integer.valueOf(gO.getVenData().toString()) == 10) {
                dataset.addValue(gO.getQuantidade(), "Outubro", "Mês");
            } else if (Integer.valueOf(gO.getVenData().toString()) == 11) {
                dataset.addValue(gO.getQuantidade(), "Novenbro", "Mês");
            } else if (Integer.valueOf(gO.getVenData().toString()) == 12) {
                dataset.addValue(gO.getQuantidade(), "Dezembro", "Mês");
            }

        }
        return dataset;
    }

    // responsavel por criar o grafico
    // mais "importante"
    public void criaGrafico(ArrayList<GraficoBEAN> a) {
        // aqui ele pega os valores que serão inseridos nele
        CategoryDataset cds = createDataset(a);
        String titulo = "Grafico - BARRA"; // título do grafico
        String eixoy = "Quantidade vendida"; // string na lateral esquerda, referente aos valores (as notas)
        String txt_legenda = "Meses"; // titulo da legenda
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gráfico de Barras");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(454, 222));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(19, 19, 360, 210);

        jButton1.setText("Gerar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(170, 250, 59, 23);

        jLabel5.setText("Ano:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 250, 30, 14);
        getContentPane().add(tfAno);
        tfAno.setBounds(60, 250, 63, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Interface gráfica/Background.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String query = "select month(venData),sum(ivQtd) from venda"
                    + "  join item_venda on venCodigo=iv_venCodigo "
                    + "and year(venData)=" + Integer.parseInt(tfAno.getText()) + " group "
                    + "by month(venData);";
            /* String query = "select venData,sum(ivQtd) from venda, item_venda\n"
                    + "where venCodigo=iv_venCodigo and year(venData)=" + tfAno.getText() + "\n"
                    + "group by  month(venData);";*/
            alG = cVenda.consultar(query);
            criaGrafico(alG);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Preencha o campo da data");
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfAno;
    // End of variables declaration//GEN-END:variables
}

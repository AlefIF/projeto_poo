/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ItemVendaControle;
import Controle.JogoControle;
import Controle.VendaControle;
import Modelo.CategoriaBEAN;
import Modelo.Con_jogoBEAN;
import Modelo.ConsoleBEAN;
import Modelo.Item_VendaBEAN;
import Modelo.JogoBEAN;
import Modelo.VendaBEAN;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Alef
 */
public class Listar_venda extends javax.swing.JFrame {

    private DefaultTableModel df;
    private VendaControle vc = new VendaControle();
    private ItemVendaControle ivc = new ItemVendaControle();
    private JogoControle jgc = new JogoControle();
    JComboBox<JogoBEAN> comboBox = new JComboBox<JogoBEAN>();
    DefaultTableModel model;

    /**
     * Creates new form Listar_venda
     */
    public Listar_venda() {
        initComponents();
        ArrayList<VendaBEAN> vb = vc.listarALL();
        ArrayList<Item_VendaBEAN> tvb = ivc.listarALL();
        ArrayList<JogoBEAN> jgL = jgc.listarALL();
        for (JogoBEAN jg : jgL) {
            comboBox.addItem(jg);
        }

        TableColumn comboColuna = tb1.getColumnModel().getColumn(5);
        comboColuna.setCellEditor(new DefaultCellEditor(comboBox));
        df = (DefaultTableModel) tb1.getModel();



        preencheTabela();

    }

    private void preencheTabela() {
        ArrayList<VendaBEAN> vb = vc.listarALL();
        ArrayList<Item_VendaBEAN> tvb = ivc.listarALL();
        ArrayList<JogoBEAN> jgL = jgc.listarALL();

        JComboBox e = new JComboBox();

        for (VendaBEAN vO : vb) {
            for (Item_VendaBEAN iO : tvb) {
                if (vO.getVenCodigo() == iO.getIv_venCodigo()) {
                    df.addRow(new Object[]{vO.getVenCodigo(), vO.getVenNNF(),
                        vO.getVenData(), vO.getVen_funCodigo(), vO.getCliente_cliCodigo(), e});
                }
            }
        }
        tb1.setModel(df);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nº N. Fiscal", "Data", "Cod Vend", "Cod Cli", "Jogo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tb1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Listar_venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar_venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar_venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar_venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listar_venda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tb1;
    // End of variables declaration//GEN-END:variables
}

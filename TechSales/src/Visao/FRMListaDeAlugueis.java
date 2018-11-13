/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.CaixaControle;
import Controle.CategoriaControle;
import Controle.ClienteControle;
import Controle.ConsoleControle;
import Controle.DevolucaoControle;
import Controle.JogoControle;
import Controle.JogoLocacaoControle;
import Controle.LocacaoControle;
import Controle.LucroControle;
import Controle.VendedorControle;
import Modelo.DevolucaoBEAN;
import Modelo.JogoBEAN;
import Modelo.JogoLocacaoBEAN;
import Modelo.LocacaoBEAN;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Modelo.RelatoriosBEAN;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alef
 */
public class FRMListaDeAlugueis extends javax.swing.JFrame {

    private ConsoleControle cControle = new ConsoleControle();
    private CategoriaControle catControle = new CategoriaControle();
    private VendedorControle cVend = new VendedorControle();
    private CaixaControle cCaixa = new CaixaControle();
    private LucroControle cLucro = new LucroControle();
    private ClienteControle contCli = new ClienteControle();
    private JogoControle contJog = new JogoControle();
    private LocacaoControle contLoc = new LocacaoControle();
    private DevolucaoControle contDev = new DevolucaoControle();
    private JogoLocacaoControle cJl = new JogoLocacaoControle();
    private DefaultTableModel modelAllLoc;
    private DefaultTableModel modelAllDev;

    /**
     * Creates new form FRMListaDeAlugueis
     */
    public FRMListaDeAlugueis() {
        initComponents();
        preencheTabelaAllDev();
        preencheTabelaAllLoc();
        this.setLocationRelativeTo(null);
        setResizable(false);
    }

    private void preencheTabelaAllDev() {
        modelAllDev = criaTabelaAllDev();
        modelAllDev.addColumn("Código-Devolução");
        modelAllDev.addColumn("Código-Locação");
        modelAllDev.addColumn("PreçoTotal");
        modelAllDev.addColumn("Multa");
        modelAllDev.addColumn("Data-DevoluçãoReal");

        for (DevolucaoBEAN d : contDev.listarALL()) {
            modelAllDev.addRow(new Object[]{d.getDevCodigo(), d.getLocacao().getLocCodigo(),
                d.getDevValor(), d.getDevMulta(), d.getDevData()});
        }

        tabelaAllDev.setModel(modelAllDev);
    }

    private DefaultTableModel criaTabelaAllDev() {
        DefaultTableModel dTable = new DefaultTableModel() {
            Class[] types = new Class[]{
                java.lang.Integer.class,
                java.lang.Integer.class,
                java.lang.Float.class,
                java.lang.Float.class,
                java.lang.String.class,};
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;
        };
    return dTable;
    }

    private void preencheTabelaAllLoc() {
        modelAllLoc = criaTabelaAllLoc();
        modelAllLoc.addColumn("Código-Locação");
        modelAllLoc.addColumn("Código-Jogo");
        modelAllLoc.addColumn("Código-Cliente");
        modelAllLoc.addColumn("Código-Vendedor");
        modelAllLoc.addColumn("Jogo");
        modelAllLoc.addColumn("Quantidade");
        modelAllLoc.addColumn("Preço Unitário");
        modelAllLoc.addColumn("Preço");
        modelAllLoc.addColumn("Situação");
        modelAllLoc.addColumn("Data-Aluguel");
        modelAllLoc.addColumn("Data-Devolução");

        for (LocacaoBEAN loc : contLoc.listarALL()) {
            for (JogoLocacaoBEAN jl : cJl.listarALL()) {
                if (loc.getLocCodigo() == jl.getChaveComposta().getLocacao().getLocCodigo()) {
                    for (JogoBEAN jogo : contJog.listarALL()) {
                        if (jogo.getJoCodigo() == jl.getChaveComposta().getJogo().getJoCodigo()) {
                            modelAllLoc.addRow(new Object[]{loc.getLocCodigo(), jogo.getJoCodigo(),
                                loc.getCliente().getCliCodigo(), loc.getVendedor().getVendedorCodigo(), jogo.getJoNome(),
                                jl.getJlQtd(), loc.getLocPrecoUnit(), loc.getLocPreçoTotal(),
                                loc.getLocStatus(), loc.getLocDataAluguel(), loc.getLocDataDevolucao()});
                        }
                    }
                }
            }
        }

        tabelaAllLoc.setModel(modelAllLoc);
    }

    private DefaultTableModel criaTabelaAllLoc() {
        DefaultTableModel dTable = new DefaultTableModel() {
            Class[] types = new Class[]{
                java.lang.Integer.class,
                java.lang.Integer.class,
                java.lang.Integer.class,
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.Integer.class,
                java.lang.Float.class,
                java.lang.Float.class,
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;
        };
    return dTable;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpGuia = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAllLoc = new javax.swing.JTable();
        tfChave4 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        btImprimir = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaAllDev = new javax.swing.JTable();
        tfChave5 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        btImprimirDev = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Locações");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tabelaAllLoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaAllLoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAllLocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAllLoc);

        tfChave4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Refinar Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        tfChave4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChave4ActionPerformed(evt);
            }
        });
        tfChave4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfChave4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfChave4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfChave4KeyTyped(evt);
            }
        });

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu de opções", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btImprimir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btImprimir.setText("Imprimir Nota");
        btImprimir.setEnabled(false);
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        btPesquisar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btPesquisar.setText("Pesquisar Devoluçao");
        btPesquisar.setEnabled(false);
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btImprimir)
                    .addComponent(btPesquisar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfChave4, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfChave4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        tpGuia.addTab("Lista de Alugueis", jPanel13);

        tabelaAllDev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaAllDev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabelaAllDevKeyTyped(evt);
            }
        });
        jScrollPane7.setViewportView(tabelaAllDev);

        tfChave5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Refinar Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        tfChave5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChave5ActionPerformed(evt);
            }
        });
        tfChave5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfChave5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfChave5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfChave5KeyTyped(evt);
            }
        });

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu de opções", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btImprimirDev.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btImprimirDev.setText("Imprimir Nota");
        btImprimirDev.setEnabled(false);
        btImprimirDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirDevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btImprimirDev, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btImprimirDev)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfChave5, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfChave5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tpGuia.addTab("Lista de Devolução", jPanel14);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Lista de Locações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpGuia)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(315, 315, 315))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpGuia))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfChave4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChave4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChave4ActionPerformed

    private void tfChave4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChave4KeyPressed

    }//GEN-LAST:event_tfChave4KeyPressed

    private void tfChave4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChave4KeyTyped

    }//GEN-LAST:event_tfChave4KeyTyped
    private void desabilitaB() {
        btPesquisar.setEnabled(false);
        btImprimir.setEnabled(false);
        btImprimirDev.setEnabled(false);
    }

    private void habilitaB() {
        btImprimir.setEnabled(true);
        btPesquisar.setEnabled(true);
    }
    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        if (tabelaAllLoc.getSelectedRow() != -1) {
            LocacaoBEAN l = contLoc.localizarLoc(Integer.parseInt(tabelaAllLoc.getValueAt(tabelaAllLoc.getSelectedRow(), 0).toString()));
            try {
                RelatoriosBEAN.notaDoAluguel(l);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FRMEmitirRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(FRMEmitirRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        desabilitaB();
    }//GEN-LAST:event_btImprimirActionPerformed

    private void tfChave5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChave5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChave5ActionPerformed

    private void tfChave5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChave5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChave5KeyPressed

    private void tfChave5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChave5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChave5KeyTyped

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        tpGuia.setSelectedIndex(1);
        desabilitaB();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void tfChave4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChave4KeyReleased
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) tabelaAllLoc.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        tabelaAllLoc.setRowSorter(sorter);
        String text = tfChave4.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_tfChave4KeyReleased

    private void tfChave5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChave5KeyReleased
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) tabelaAllDev.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        tabelaAllDev.setRowSorter(sorter);
        String text = tfChave5.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_tfChave5KeyReleased

    private void btImprimirDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirDevActionPerformed
        if (tabelaAllDev.getSelectedRow() != -1) {
            DevolucaoBEAN d = contDev.localizar(Integer.parseInt(tabelaAllDev.getValueAt(tabelaAllDev.getSelectedRow(), 0).toString()));
            try {
                RelatoriosBEAN.notaDaDev(d);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FRMEmitirRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(FRMEmitirRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        desabilitaB();
    }//GEN-LAST:event_btImprimirDevActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tabelaAllLocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAllLocMouseClicked
        if (tabelaAllLoc.getSelectedRow() != -1) {
            habilitaB();
        }
    }//GEN-LAST:event_tabelaAllLocMouseClicked

    private void tabelaAllDevKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaAllDevKeyTyped
        if (tabelaAllLoc.getSelectedRow() != -1) {
            btImprimirDev.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaAllDevKeyTyped

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
            java.util.logging.Logger.getLogger(FRMListaDeAlugueis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMListaDeAlugueis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMListaDeAlugueis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMListaDeAlugueis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMListaDeAlugueis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btImprimirDev;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tabelaAllDev;
    private javax.swing.JTable tabelaAllLoc;
    private javax.swing.JTextField tfChave4;
    private javax.swing.JTextField tfChave5;
    private javax.swing.JTabbedPane tpGuia;
    // End of variables declaration//GEN-END:variables
}

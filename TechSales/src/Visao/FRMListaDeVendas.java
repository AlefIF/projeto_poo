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
import Controle.FuncionarioControle;
import Controle.JogoControle;
import Controle.JogoVendaControle;
import Controle.LucroControle;
import Controle.VendaAPrazoControle;
import Controle.VendaControle;
import Controle.VendedorControle;
import Modelo.CaixaBEAN;
import Modelo.JogoVendaBEAN;
import Modelo.VendaAPrazoBEAN;
import Modelo.VendaBEAN;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Modelo.RelatoriosBEAN;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;

/**
 *
 * @author Alef
 */
public class FRMListaDeVendas extends javax.swing.JFrame {

    private JogoControle jControle = new JogoControle();
    private ConsoleControle cControle = new ConsoleControle();
    private CategoriaControle catControle = new CategoriaControle();
    private ClienteControle cCliente = new ClienteControle();
    private VendaControle cVenda = new VendaControle();
    private VendaAPrazoControle cVendaPrazo = new VendaAPrazoControle();
    private FuncionarioControle cFun = new FuncionarioControle();
    private VendedorControle cVend = new VendedorControle();
    private CaixaControle cCaixa = new CaixaControle();
    private LucroControle cLucro = new LucroControle();
    private JogoVendaControle Cjv = new JogoVendaControle();
    private DefaultTableModel dTablePrazo;
    private DefaultTableModel dTableVenda;
    private int cod = 0;

    /**
     * Creates new form FRMListaDeVendas
     */
    public FRMListaDeVendas() {
        initComponents();
        preencheTabelaVenda();
        preencheTabelaPrazo(cod);
        this.setLocationRelativeTo(null);
        setResizable(false);
    }

    private void preencheTabelaVenda() {
        dTableVenda = criaTabelaVenda();
        dTableVenda.addColumn("Código");
        dTableVenda.addColumn("Data");
        dTableVenda.addColumn("Preço Total");
        dTableVenda.addColumn("Numero de Parcelas");
        dTableVenda.addColumn("Entrada");

        dTableVenda.addColumn("Código do jogo");
        dTableVenda.addColumn("Preço Unitário");
        dTableVenda.addColumn("Quantidade Comprada");

        for (VendaBEAN n : cVenda.listarALL()) {
            for (JogoVendaBEAN jv : Cjv.listarALL()) {
                if (jv.getChaveComposta().getVenda().getVendaCodigo() == n.getVendaCodigo()) {
                    dTableVenda.addRow(new Object[]{n.getVendaCodigo(), n.getVendaData(), n.getVendaValorTotal(),
                        n.getVendaNparcelas(), n.getVendaEntrada(),
                        jv.getChaveComposta().getJogo().getJoCodigo(), jv.getPrecoUnitarioReal(),
                        jv.getQuantidade()});
                }
            }
        }

        tableVendas.setModel(dTableVenda);
    }

    private DefaultTableModel criaTabelaVenda() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel dTable = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.Float.class,
                java.lang.Integer.class,
                java.lang.Float.class,
                java.lang.Integer.class,
                java.lang.Float.class,
                java.lang.Integer.class};
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
        //retorna o DefaultTableModel
    return dTable;
    }

    private void preencheTabelaPrazo(int c) {
        dTablePrazo = criaTabelaPrazo();
        //seta o nome das colunas da tabela
        dTablePrazo.addColumn("Código");
        dTablePrazo.addColumn("Data");
        dTablePrazo.addColumn("Valor da Parcela");
        dTablePrazo.addColumn("Numero da Parcela");
        dTablePrazo.addColumn("Codigo da Nota De Compra");
        dTablePrazo.addColumn("Situação");
        //pega os dados do ArrayList

        for (VendaAPrazoBEAN n : cVendaPrazo.listarALL()) {
            if (n.getVenda().getVendaCodigo() == c) {
                dTablePrazo.addRow(new Object[]{n.getVapCodigo(), n.getVapData(), n.getVapValorParcela(),
                    n.getVapNumParcela(), n.getVenda().getVendaCodigo(), n.getVapSituacao()});
            }
        }

        tableVenParcela.setModel(dTablePrazo);
    }

    private DefaultTableModel criaTabelaPrazo() {
        DefaultTableModel dTable = new DefaultTableModel() {
            Class[] types = new Class[]{
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.Float.class,
                java.lang.Integer.class,
                java.lang.Integer.class,
                java.lang.String.class

            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false};

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
        jPanel2 = new javax.swing.JPanel();
        tables = new javax.swing.JScrollPane();
        tableVendas = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btLocalizar = new javax.swing.JButton();
        btImprimirNota = new javax.swing.JButton();
        tfChave = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        tables1 = new javax.swing.JScrollPane();
        tableVenParcela = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        btPagar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVendasMouseClicked(evt);
            }
        });
        tables.setViewportView(tableVendas);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu de Seleção", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btLocalizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btLocalizar.setText("Localizar Parcelas");
        btLocalizar.setEnabled(false);
        btLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocalizarActionPerformed(evt);
            }
        });

        btImprimirNota.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btImprimirNota.setText("Imprimir Nota");
        btImprimirNota.setEnabled(false);
        btImprimirNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirNotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btImprimirNota, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLocalizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btImprimirNota, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tfChave.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Refinar Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        tfChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChaveActionPerformed(evt);
            }
        });
        tfChave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfChaveKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfChaveKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfChaveKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tables, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tfChave, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tables, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpGuia.addTab("Lista de Vendas", jPanel2);

        tables1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tables1MouseClicked(evt);
            }
        });

        tableVenParcela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableVenParcela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVenParcelaMouseClicked(evt);
            }
        });
        tables1.setViewportView(tableVenParcela);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu de Seleção", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btPagar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btPagar.setText("Pagar Parcela");
        btPagar.setEnabled(false);
        btPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btPagar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tables1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tables1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpGuia.addTab("Lista de Parcelas", jPanel6);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Lista de Vendas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpGuia, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tpGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalizarActionPerformed
        VendaBEAN n = cVenda.localizar(Integer.parseInt(tableVendas.getValueAt(tableVendas.getSelectedRow(), 0).toString()));
        cod = n.getVendaCodigo();
        preencheTabelaPrazo(cod);
        tpGuia.setSelectedIndex(1);
    }//GEN-LAST:event_btLocalizarActionPerformed

    private void btImprimirNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirNotaActionPerformed
        VendaBEAN v = cVenda.localizar(Integer.parseInt(tableVendas.getValueAt(tableVendas.getSelectedRow(), 0).toString()));
        try {
            RelatoriosBEAN.notaDaVenda(v);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FRMEmitirRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(FRMEmitirRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btImprimirNotaActionPerformed

    private void tfChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChaveActionPerformed

    private void tfChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChaveKeyPressed

    }//GEN-LAST:event_tfChaveKeyPressed

    private void tfChaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChaveKeyTyped

    }//GEN-LAST:event_tfChaveKeyTyped

    private void tableVenParcelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVenParcelaMouseClicked
        if (tableVenParcela.getSelectedRow() != -1) {
            btPagar.setEnabled(true);
        }
    }//GEN-LAST:event_tableVenParcelaMouseClicked

    private void tables1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tables1MouseClicked

    }//GEN-LAST:event_tables1MouseClicked

    private void btPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPagarActionPerformed
        VendaAPrazoBEAN j = cVendaPrazo.localizarCodigo(Integer.parseInt(tableVenParcela.getValueAt(tableVenParcela.getSelectedRow(), 0).toString()));
        j.setVapSituacao("Paga");
        CaixaBEAN caixa = cCaixa.localizar(1);
        caixa.setCaixaDinheiro(caixa.getCaixaDinheiro() + j.getVapValorParcela());
        cCaixa.editar(caixa);
        boolean retorno = cVendaPrazo.editar(j);
        if (retorno == true) {
            JOptionPane.showMessageDialog(null, "Nota MODIFICADA com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "ERRO na EDIÇÃO");
        }
        preencheTabelaPrazo(j.getVenda().getVendaCodigo());
    }//GEN-LAST:event_btPagarActionPerformed

    private void tfChaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChaveKeyReleased
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) tableVendas.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        tableVendas.setRowSorter(sorter);
        String text = tfChave.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_tfChaveKeyReleased

    private void tableVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVendasMouseClicked
        if (tableVendas.getSelectedRow() != -1) {
            btLocalizar.setEnabled(true);
            btImprimirNota.setEnabled(true);
        }
    }//GEN-LAST:event_tableVendasMouseClicked

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
            java.util.logging.Logger.getLogger(FRMListaDeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMListaDeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMListaDeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMListaDeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMListaDeVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimirNota;
    private javax.swing.JButton btLocalizar;
    private javax.swing.JButton btPagar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTable tableVenParcela;
    private javax.swing.JTable tableVendas;
    private javax.swing.JScrollPane tables;
    private javax.swing.JScrollPane tables1;
    private javax.swing.JTextField tfChave;
    private javax.swing.JTabbedPane tpGuia;
    // End of variables declaration//GEN-END:variables
}

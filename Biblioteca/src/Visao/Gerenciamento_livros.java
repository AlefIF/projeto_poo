package Visao;

import Controle.LivroControle;
import Modelo.Genero;
import Modelo.GeneroDAO;
import Modelo.Livro;
import Modelo.LivroDAO;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.text.StyledEditorKit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LUCASP
 */
public class Gerenciamento_livros extends javax.swing.JFrame {

    //ArayList para receber valores do banco de dados
    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Genero> generos = new ArrayList<>();
    //objeto para acesso aos métodos do dao
    LivroControle controle = new LivroControle();
    LivroDAO lDAO = new LivroDAO();
    JComboBox<Genero> cbGnero = new JComboBox<>();

    //cria um modelo padrão de tabela para ser trabalhado
    DefaultTableModel model;

    /**
     * Creates new form Gerenciamento_livros
     */
    GeneroDAO genDAO = new GeneroDAO();

    public Gerenciamento_livros() {
        initComponents();

        for (Genero d : genDAO.listarALL()) {
            cbGnero.addItem(d);
        }

        //'modelo padrão' recebe o mesmo modelo da tabela colocada no frame    
        model = (DefaultTableModel) tbLivros2.getModel();
        
        //esse método permite ordenar (ASC|DESC) as rows através do clique no título da coluna
        tbLivros2.setRowSorter(new TableRowSorter(model));

        //add comboBox à coluna desejada
        TableColumn tc2 = tbLivros2.getColumnModel().getColumn(2);
        tc2.setCellEditor(new DefaultCellEditor(cbGnero));
        model = (DefaultTableModel) tbLivros2.getModel();

        livros = lDAO.listarALL();
        //já preenchee atabela com as informações que já estão no bd 
        for (Livro l : livros) {
            preencheTabela(l);
        }

    }

    //verifica se todos os valores necessários para o cadastro foram preenchidos corretamente
    public boolean verificaCampos() {
        if (txTitulo.getText().equals("") || txAutor.getText().equals("")) {
            return false;

        }
        return true;

    }

    //recebe os valores alterados ou não da row e os atualiza tanto na table quanto no banco de dados
    public void atualizaValores(Livro l) {

        //obtém valores da table para atualizar no banco de dados
        //caso nenhum livro seja selecionado para ser atualizado, o usuário é avisado dessa violação
        try {
            //transforma os valores de cada row em um vetor
            Vector v = (Vector) model.getDataVector().elementAt(tbLivros2.getSelectedRow());

            //transforma os valores de cada coluna em uma instância no array Object
            Object[] o = v.toArray();

            generos = genDAO.listarALL();

            livros = lDAO.listarALL();
            l.setId(livros.get(tbLivros2.getSelectedRow()).getId());
            l.setTitulo((String) o[0]);
            l.setAutor((String) o[1]);
            l.setGenero(generos.get(cbGnero.getSelectedIndex()).getId());
            l.setSituacao((Boolean) o[3]);
            //controle.atualizar(l);
            lDAO.editar(l);

            System.out.println(livros.get(tbLivros2.getSelectedRow()).isSituacao());
        } catch (ArrayIndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(null, "Nenhum livro a ser atualizado");
            //e.printStackTrace();

        }

    }

    public void excluirDado(Livro l) {

        //obtém valores da table para atualizar no banco de dados
        //caso nenhum livro seja selecionado para ser atualizado, o usuário é avisado dessa violação
        try {
            //transforma os valores de cada row em um vetor
            Vector v = (Vector) model.getDataVector().elementAt(tbLivros2.getSelectedRow());

            //transforma os valores de cada coluna em uma instância no array Object
            Object[] o = v.toArray();
            livros = lDAO.listarALL();
            l.setId(livros.get(tbLivros2.getSelectedRow()).getId());

            //controle.atualizar(l);
            lDAO.remover(l);

            System.out.println(livros.get(tbLivros2.getSelectedRow()).isSituacao());
        } catch (ArrayIndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(null, "Nenhum livro a ser excluir");
            //e.printStackTrace();

        }
    }

    //busca valores do bd e preenche a tabela
    public void preencheTabela(Livro l) {
        
        GeneroDAO genDAO = new GeneroDAO();
        Genero g = genDAO.listarPorId(l.getGenero());
        model.addRow(new Object[]{l.getTitulo().toString(), l.getAutor().toString(), g, l.isSituacao()});

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txTitulo = new javax.swing.JTextField();
        txAutor = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLivros2 = new javax.swing.JTable();
        btAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Título:");

        jLabel3.setText("Autor:");

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        tbLivros2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor", "Gênero", "Emprestado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbLivros2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLivros2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLivros2);

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(btCadastrar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAtualizar)
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btCadastrar)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btAtualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        //cria um novo objeto para receber valores da row selecionada
        Livro l = new Livro();
        atualizaValores(l);
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void tbLivros2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLivros2MouseClicked

    }//GEN-LAST:event_tbLivros2MouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        Livro l = new Livro();

        excluirDado(l);
        
        //remove também esta row da table
        model.removeRow(tbLivros2.getSelectedRow());
        livros = lDAO.listarALL();

        System.out.println(livros.size());


    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed

        if (verificaCampos()) {
            //instancia um novo objeto livro com os dados inseridas
            Livro l = new Livro();
            l.setAutor(txAutor.getText());
            l.setGenero(5);
            l.setSituacao(false);
            l.setTitulo(txTitulo.getText());

            //método explicado
            preencheTabela(l);

            //persiste o objeto no bd
            controle.cadastrar(l);

            //livros recebe todos os livros que estão no bd
            livros = lDAO.listarALL();
            System.out.println(livros.size());
            limpaCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Insira todos os campos");
        }


    }//GEN-LAST:event_btCadastrarActionPerformed

    //esvazia os campos preenchidos
    public void limpaCampos() {
        txTitulo.setText("");
        txAutor.setText("");

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
            java.util.logging.Logger.getLogger(Gerenciamento_livros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerenciamento_livros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerenciamento_livros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerenciamento_livros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerenciamento_livros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLivros2;
    private javax.swing.JTextField txAutor;
    private javax.swing.JTextField txTitulo;
    // End of variables declaration//GEN-END:variables
}

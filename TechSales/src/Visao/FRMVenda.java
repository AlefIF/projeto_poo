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
import Modelo.CategoriaBEAN;
import Modelo.ClienteBEAN;
import Modelo.ConsoleBEAN;
import Modelo.JogoBEAN;
import Modelo.FuncionarioBEAN;
import Modelo.JogoVendaBEAN;
import Modelo.JogoVendaPK;
import Modelo.RelatoriosBEAN;
import Modelo.VendaAPrazoBEAN;
import Modelo.VendaBEAN;
import Modelo.VendedorBEAN;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Alef
 */
public class FRMVenda extends javax.swing.JFrame {

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
    private DefaultTableModel dTableJogo;
    private DefaultTableModel dTableCliente;
    private DefaultTableModel dTableCarro1;
    private DefaultTableModel dTableCarro2;
    private DefaultTableModel dTablePrazo;
    private DefaultTableModel dTableVenda;
    private DefaultTableModel dTPrazo;
    private ArrayList<JogoBEAN> jDados;
    private ArrayList<CategoriaBEAN> catDados;
    private ArrayList<ConsoleBEAN> cDados;
    private ArrayList<ClienteBEAN> cdados;
    private ArrayList<FuncionarioBEAN> userD;
    private ArrayList<VendaAPrazoBEAN> insertData = new ArrayList<VendaAPrazoBEAN>();
    private ArrayList<JogoBEAN> insertJogo = new ArrayList<JogoBEAN>();
    private int cod = 0;

    /**
     * Creates new form FRMVenda
     */
    public FRMVenda() {
        initComponents();
        setResizable(false);
        preencheTabelaJogo();
        preencheTabelaCliente();
        preencheTabelaCarro1();
        preencheTabelaCarro2();
        preencheTabelaVenda();
        preencheTabelaPrazo(cod);
        lbVendedorCod.setText(String.valueOf(FRMLogin.user.getVendedorCodigo()));
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
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel dTable = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.Float.class,
                java.lang.Integer.class,
                java.lang.Integer.class,
                java.lang.String.class

            };
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
        //retorna o DefaultTableModel
    return dTable;
    }

    private void preencheTabelaJogo() {
        dTableJogo = criaTabelaJogo();
        //seta o nome das colunas da tabela
        dTableJogo.addColumn("Código");
        dTableJogo.addColumn("Nome");
        dTableJogo.addColumn("Fornecedor");
        dTableJogo.addColumn("Faixa Etária");
        dTableJogo.addColumn("Preço Padrão");
        dTableJogo.addColumn("Tipo de Jogo");
        dTableJogo.addColumn("Categoria");
        dTableJogo.addColumn("Console");
        dTableJogo.addColumn("Lote");
        dTableJogo.addColumn("Quantidade");
        //pega os dados do ArrayList
        jDados = jControle.listarALL();
        catDados = catControle.listarALL();
        cDados = cControle.listarALL();

        for (JogoBEAN dado : jDados) {
            for (CategoriaBEAN dado2 : catDados) {
                if (dado.getCat().getCatCodigo() == dado2.getCatCodigo()) {
                    for (ConsoleBEAN c : cDados) {
                        if (dado.getConsole().getConCodigo() == c.getConCodigo()) {
                            dTableJogo.addRow(new Object[]{dado.getJoCodigo(), dado.getJoNome(), dado.getFornecedor(),
                                dado.getJoFaixaEtaria(), dado.getJoPrecoPadrao(), dado.getJoTipo(),
                                dado2.getCatNome(), c.getConNome(), dado.getJoLote(), dado.getJoQtd()});
                        }
                    }
                }
            }
        }
        tableJogo.setModel(dTableJogo);
    }

    private DefaultTableModel criaTabelaJogo() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel dTable = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.Double.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.Integer.class
            };
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
        //retorna o DefaultTableModel
    return dTable;
    }

    private void preencheTabelaCliente() {
        dTableCliente = criaTabelaCliente();

        dTableCliente.addColumn("Código");
        dTableCliente.addColumn("Nome");
        dTableCliente.addColumn("Idade");
        dTableCliente.addColumn("Telefone");
        dTableCliente.addColumn("CPF");
        dTableCliente.addColumn("email");

        for (ClienteBEAN dado : cCliente.listarALL()) {
            dTableCliente.addRow(new Object[]{dado.getCliCodigo(), dado.getCliNome(), dado.getCliIdade(),
                dado.getCliTelefone(), dado.getCliCpf(), dado.getCliEmail()});

        }
        //set o modelo da tabela
        tableCliente.setModel(dTableCliente);
    }

    private DefaultTableModel criaTabelaCliente() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel cTable = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class,
                java.lang.Integer.class
            };
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
        //retorna o DefaultTableModel
    return cTable;
    }

    private void preencheTabelaCarro1() {
        dTableCarro1 = criaTabelaCarro1();
        //seta o nome das colunas da tabela
        dTableCarro1.addColumn("Jogo");
        dTableCarro1.addColumn("Preço");
        dTableCarro1.addColumn("Quantidade");

        for (JogoBEAN j : insertJogo) {
            dTableCarro1.addRow(new Object[]{j.getJoNome(), j.getJoPrecoPadrao(), j.getJoQtd()});
        }

        tableJogoCarrinho.setModel(dTableCarro1);
    }

    private DefaultTableModel criaTabelaCarro1() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel cTable = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class,};
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
    return cTable;
    }

    private void preencheTabelaCarro2() {
        dTableCarro2 = criaTabelaCarro2();
        dTableCarro2.addColumn("Jogo");
        dTableCarro2.addColumn("Preço");
        dTableCarro2.addColumn("Quantidade");

        for (JogoBEAN j : insertJogo) {
            dTableCarro2.addRow(new Object[]{j.getJoNome(), j.getJoPrecoPadrao(), j.getJoQtd()});
        }

        tableJogoCarrinho2.setModel(dTableCarro2);
    }

    private DefaultTableModel criaTabelaCarro2() {
        DefaultTableModel rcTable = new DefaultTableModel() {
            Class[] types = new Class[]{
                 java.lang.String.class, java.lang.Float.class, java.lang.Integer.class};
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
    return rcTable;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tpGuia = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableJogoCarrinho2 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        lbCliCod = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jpCompra = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableM = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        tfValorEntrada = new javax.swing.JTextField();
        tfPrecott = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tfNParcelas = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tfDataCompra = new javax.swing.JFormattedTextField();
        lbVendedorCod = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJogo = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableJogoCarrinho = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tfChave3 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();
        tfChave2 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carrinho de compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tableJogoCarrinho2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogo", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableJogoCarrinho2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(tableJogoCarrinho2);

        jButton6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton6.setText("Adcionar Jogo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton7.setText("Exlcuir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        lbCliCod.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbCliCod.setText("...");
        lbCliCod.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Código Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jButton11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton11.setText("Selecionar Cliente");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCliCod, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCliCod)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpCompra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setText("Gerar Parcelas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tableM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num.Parcela", "Data", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableM.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableM);

        jButton8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton8.setText("Excluir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Preço Total:");

        tfValorEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorEntradaActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Valor de entrada:");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Número de parcelas:");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Data da Venda:");

        try{
            javax.swing.text.MaskFormatter faixa= new javax.swing.text.MaskFormatter("##/##/####");
            tfDataCompra = new javax.swing.JFormattedTextField(faixa);
        }
        catch (Exception e){
        }

        lbVendedorCod.setText("...");
        lbVendedorCod.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Código do Vendedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jButton14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton14.setText("Editar Parcela");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCompraLayout = new javax.swing.GroupLayout(jpCompra);
        jpCompra.setLayout(jpCompraLayout);
        jpCompraLayout.setHorizontalGroup(
            jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpCompraLayout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfNParcelas))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpCompraLayout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addGap(18, 18, 18)
                            .addComponent(tfDataCompra))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpCompraLayout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfPrecott))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpCompraLayout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfValorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbVendedorCod, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpCompraLayout.createSequentialGroup()
                            .addComponent(jButton14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8))
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpCompraLayout.setVerticalGroup(
            jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCompraLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbVendedorCod)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCompraLayout.createSequentialGroup()
                        .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPrecott, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(12, 12, 12)
                        .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfValorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(tfDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)))
                    .addGroup(jpCompraLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu de opções", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Gravar Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton17.setText("Nova Venda");

        jButton18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton18.setText("Cancelar");

        jButton19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton19.setText("Fechar");

        jButton21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton21.setText("Localizar Venda");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpGuia.addTab("Realizar Venda", jPanel3);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableJogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableJogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableJogoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableJogo);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carrinho de Compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tableJogoCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogo", "Preço", "Quantidade"
            }
        ));
        tableJogoCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableJogoCarrinhoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableJogoCarrinho);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setText("Adcionar Jogo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tfChave3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Refinar Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        tfChave3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChave3ActionPerformed(evt);
            }
        });
        tfChave3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfChave3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfChave3KeyTyped(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu de opções", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jButton5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton5.setText("Carrinho Completo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton22.setText("Cancelar");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGap(32, 32, 32)
                .addComponent(jButton22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tfChave3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tfChave3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        tpGuia.addTab("Selecionar jogos", jPanel5);

        tableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCliente);

        tfChave2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Refinar Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        tfChave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChave2ActionPerformed(evt);
            }
        });
        tfChave2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfChave2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfChave2KeyTyped(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu de Seleção", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jButton20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton20.setText("Selecionar Cliente");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton20)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(tfChave2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfChave2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpGuia.addTab("Selecionar Cliente", jPanel7);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel3.setText("Realizar Venda");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableJogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableJogoMouseClicked

    }//GEN-LAST:event_tableJogoMouseClicked

    private void tableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClienteMouseClicked
        if (tableCliente.getSelectedRow() != -1) {
            ClienteBEAN c = cCliente.localizarCodigo(Integer.parseInt(tableCliente.getValueAt(tableCliente.getSelectedRow(), 0).toString()));
            lbCliCod.setText(String.valueOf(c.getCliCodigo()));
            tpGuia.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tableClienteMouseClicked
    private void cadastroNormal() {
        VendaBEAN v = new VendaBEAN();
        ClienteBEAN c = cCliente.localizarCodigo(Integer.valueOf(lbCliCod.getText()));
        VendedorBEAN vend = cVend.localizar(Integer.valueOf(lbVendedorCod.getText()));
        CaixaBEAN caixa = cCaixa.localizar(1);
        v.setCliente(c);
        v.setVendedor(vend);
        v.setCaixa(caixa);
        v.setVendaNparcelas(Integer.parseInt(tfNParcelas.getText()));
        v.setVendaEntrada(Float.parseFloat(tfValorEntrada.getText()));
        v.setVendaValorTotal(Float.parseFloat(tfPrecott.getText()));

        try {
            String dataString = tfDataCompra.getText();
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());
            v.setVendaData(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cVenda.cadastrar(v);

        caixa.setCaixaDinheiro(caixa.getCaixaDinheiro() + v.getVendaEntrada());
        cCaixa.editar(caixa);

        for (JogoBEAN j : insertJogo) {
            for (JogoBEAN jogoEstoque : jControle.listarALL()) {
                if (jogoEstoque.getJoCodigo() == j.getJoCodigo()) {
                    JogoVendaBEAN jv = new JogoVendaBEAN();
                    JogoVendaPK jvpk = new JogoVendaPK();
                    jvpk.setJogo(j);
                    jvpk.setVenda(v);
                    jv.setChaveComposta(jvpk);
                    jv.setPrecoUnitarioReal(j.getJoPrecoPadrao());
                    jv.setQuantidade(j.getJoQtd());
                    Cjv.cadastrar(jv);
                    int qtd = jogoEstoque.getJoQtd() - j.getJoQtd();
                    jogoEstoque.setJoQtd(qtd);
                    jControle.editar(jogoEstoque);
                }
            }
        }

        limparCampos();
    }

    private void cadastroInserir() {
        VendaBEAN v = new VendaBEAN();
        ClienteBEAN c = cCliente.localizarCodigo(Integer.valueOf(lbCliCod.getText()));
        VendedorBEAN vend = cVend.localizar(Integer.valueOf(lbVendedorCod.getText()));
        CaixaBEAN caixa = cCaixa.localizar(1);
        v.setCliente(c);
        v.setVendedor(vend);
        v.setCaixa(caixa);
        v.setVendaNparcelas(Integer.parseInt(tfNParcelas.getText()));
        v.setVendaEntrada(Float.parseFloat(tfValorEntrada.getText()));
        v.setVendaValorTotal(Float.parseFloat(tfPrecott.getText()));
        try {
            String dataString = tfDataCompra.getText();
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());
            v.setVendaData(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cVenda.cadastrar(v);

        caixa.setCaixaDinheiro(caixa.getCaixaDinheiro() + v.getVendaEntrada());
        cCaixa.editar(caixa);

        for (VendaAPrazoBEAN ndca : insertData) {
            VendaAPrazoBEAN nota = new VendaAPrazoBEAN();
            nota.setVapData(ndca.getVapData());
            nota.setVapValorParcela(ndca.getVapValorParcela());
            nota.setVapNumParcela(ndca.getVapNumParcela());
            nota.setVapSituacao("Pendente");
            nota.setVenda(v);
            cVendaPrazo.cadastrar(nota);
        }

        for (JogoBEAN j : insertJogo) {
            for (JogoBEAN jogoEstoque : jControle.listarALL()) {
                if (jogoEstoque.getJoCodigo() == j.getJoCodigo()) {
                    JogoVendaBEAN jv = new JogoVendaBEAN();
                    JogoVendaPK jvpk = new JogoVendaPK();
                    jvpk.setJogo(j);
                    jvpk.setVenda(v);
                    jv.setChaveComposta(jvpk);
                    jv.setPrecoUnitarioReal(j.getJoPrecoPadrao());
                    jv.setQuantidade(j.getJoQtd());
                    Cjv.cadastrar(jv);
                    int qtd = jogoEstoque.getJoQtd() - j.getJoQtd();
                    jogoEstoque.setJoQtd(qtd);
                    jControle.editar(jogoEstoque);
                }
            }
        }

        resultado();
    }

    private void resultado() {
        insertData.clear();
        limparCampos();
        JOptionPane.showMessageDialog(null, "Notas CADASTRADAS com sucesso");
    }

    private int verificarInserir() {
        int j = 0;
        for (VendaAPrazoBEAN a : insertData) {
            j++;
        }
        System.out.println(j);
        return j;
    }

    private boolean verificaCampos() {
        if (tfPrecott.getText().equals("") || tfValorEntrada.getText().equals("")
                || tfDataCompra.getText().equals("")
                || lbCliCod.getText().equals("...")
                || lbVendedorCod.getText().equals("...")
                || tfNParcelas.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private boolean verificaCampos2() {
        if (tfPrecott.getText().equals("") || tfValorEntrada.getText().equals("")
                || tfNParcelas.getText().equals("")
                || tfDataCompra.getText().equals("")
                || lbCliCod.getText().equals("...")
                || lbVendedorCod.getText().equals("...")) {
            return false;
        } else {
            return true;
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int z = verificarInserir();
        if (z == 0) {
            if (verificaCampos()) {
                this.cadastroNormal();
                preencheTabelaVenda();
                JOptionPane.showMessageDialog(null, "Nota Cadastrada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro!Preencha todos os campos.");
            }
        } else if (verificaCampos2()) {
            if (Integer.parseInt(tfNParcelas.getText()) != tableM.getRowCount()) {
                JOptionPane.showMessageDialog(null, "Erro! A quantidade de parcelas registradas não é igual à fornecida");
            } else {
                this.cadastroInserir();
                preencheTabelaVenda();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro!Preencha todos os campos.");
        }

        insertJogo.clear();
        preencheTabelaCarro1();
        preencheTabelaCarro2();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        tpGuia.setSelectedIndex(1);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (tableJogoCarrinho2.getSelectedRow() != -1) {
            int i = tableJogoCarrinho2.getSelectedRow();
            insertJogo.remove(i);
            preencheTabelaCarro1();
            preencheTabelaCarro2();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o jogo");
        }

    }//GEN-LAST:event_jButton7ActionPerformed


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (tableJogo.getSelectedRow() != -1) {
            JogoBEAN j = jControle.localizarCodigo(Integer.parseInt(tableJogo.getValueAt(tableJogo.getSelectedRow(), 0).toString()));
            float lucro = ((j.getLucro().getLucPorcentagem() * j.getJoPrecoPadrao()) / 100);
            float precoSug = lucro + j.getJoPrecoPadrao();
            float preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o preço praticado do Jogo"
                    + "\n" + "Preço sugerido: " + precoSug));
            if (preco > 0) {
                if (preco >= precoSug) {
                    int qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a Quantidade de jogos"));
                    if (qtd <= j.getJoQtd()) {
                        if (tableJogo.getSelectedRow() != -1) {
                            JogoBEAN wtf = new JogoBEAN();
                            wtf.setJoNome(j.getJoNome());
                            wtf.setJoPrecoPadrao(preco);
                            wtf.setJoQtd(qtd);
                            insertJogo.add(wtf);
                            preencheTabelaCarro1();
                            preencheTabelaCarro2();
                        } else {
                            JOptionPane.showMessageDialog(null, "Selecione o jogo");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Quantidade não disponível");
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "O preço esta abaixo do Lucro padrão. Deseja proseguir?");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Preço inválido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o jogo");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tableJogoCarrinho.getSelectedRow() != -1) {
            int i = tableJogoCarrinho.getSelectedRow();
            insertJogo.remove(i);
            preencheTabelaCarro1();
            preencheTabelaCarro2();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o jogo");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableJogoCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableJogoCarrinhoMouseClicked
        int i = tableJogoCarrinho2.getSelectedRow();
    }//GEN-LAST:event_tableJogoCarrinhoMouseClicked


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int t = Integer.parseInt(tfNParcelas.getText());
        float precoTT = Float.parseFloat((tfPrecott.getText()));
        float precoParcelaTT = precoTT - Float.parseFloat((tfValorEntrada.getText()));
        for (int c = 1; c <= t; c++) {
            java.sql.Date data = null;
            try {
                String dataString = tfDataCompra.getText();
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                data = new java.sql.Date(fmt.parse(dataString).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            VendaAPrazoBEAN nota = new VendaAPrazoBEAN();
            int m = data.getMonth();
            data.setMonth(m + c);
            nota.setVapValorParcela(precoParcelaTT / t);
            nota.setVapNumParcela(c);
            nota.setVapData(data);
            insertData.add(nota);
        }
        preecheTabelaPrazos();
    }//GEN-LAST:event_jButton4ActionPerformed
    private void preecheTabelaPrazos() {
        dTPrazo = criaTabelaPrazos();
        dTPrazo.addColumn("Num.Parcela");
        dTPrazo.addColumn("Data");
        dTPrazo.addColumn("Preço-Parcela");

        for (VendaAPrazoBEAN n : insertData) {
            dTPrazo.addRow(new Object[]{n.getVapNumParcela(), n.getVapData(), n.getVapValorParcela()});
        }
        tableM.setModel(dTPrazo);
    }

    private DefaultTableModel criaTabelaPrazos() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel dTable2 = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.Float.class,};
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;
        };
        //retorna o DefaultTableModel
    return dTable2;
    }
    private void tableMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMMouseClicked
        int i = tableM.getSelectedRow();
    }//GEN-LAST:event_tableMMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int i = tableM.getSelectedRow();
        if (i != -1) {
            insertData.remove(i);
            preencheTabelaPrazo(cod);
        } else {
            JOptionPane.showMessageDialog(null, " Selecione alguma linha na tabela");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tfValorEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfValorEntradaActionPerformed
    private void limparCampos() {
        lbCodVenda.setText("");
        lbCliCod.setText("");
        tfPrecott.setText("");
        tfValorEntrada.setText("");
        tfDataCompra.setText("");
        tfNParcelas.setText("");
        tfDataParcela2.setText("");
        tfPrecoParcela2.setText("");
        insertJogo.clear();
        preencheTabelaCarro1();
        preencheTabelaCarro2();
        preencheTabelaJogo();
        preencheTabelaVenda();
    }

    private void editParcela() {
        VendaAPrazoBEAN j = cVendaPrazo.localizarCodigo(Integer.parseInt(lbCodPar.getText()));
        j.setVapValorParcela(Float.parseFloat(tfPrecoParcela2.getText()));

        try {
            String dataString = tfDataParcela2.getText();
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());
            j.setVapData(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean retorno = cVendaPrazo.editar(j);
        if (retorno == true) {
            JOptionPane.showMessageDialog(null, "Parcela MODIFICADA com sucesso");
            this.preencheTabelaCliente();
            preencheTabelaCarro1();
            this.limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "ERRO na EDIÇÃO");
        }

        preencheTabelaPrazo(j.getVenda().getVendaCodigo());
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        double precoTT = 0;
        for (int i = 0; i < tableJogoCarrinho2.getRowCount(); i++) {
            precoTT += (Double.parseDouble((tableJogoCarrinho2.getValueAt(i, 2)).toString())
                    * Double.parseDouble((tableJogoCarrinho2.getValueAt(i, 3)).toString()));
        }
        tfPrecott.setText(String.valueOf(precoTT));
        tpGuia.setSelectedIndex(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        tpGuia.setSelectedIndex(2);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void tfChave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChave2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChave2ActionPerformed

    private void tfChave2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChave2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChave2KeyPressed

    private void tfChave2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChave2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChave2KeyTyped

    private void tfChave3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChave3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChave3ActionPerformed

    private void tfChave3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChave3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChave3KeyPressed

    private void tfChave3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChave3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChave3KeyTyped

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

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
            java.util.logging.Logger.getLogger(FRMVenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMVenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMVenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMVenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpCompra;
    private javax.swing.JLabel lbCliCod;
    private javax.swing.JLabel lbVendedorCod;
    private javax.swing.JTable tableCliente;
    private javax.swing.JTable tableJogo;
    private javax.swing.JTable tableJogoCarrinho;
    private javax.swing.JTable tableJogoCarrinho2;
    private javax.swing.JTable tableM;
    private javax.swing.JTextField tfChave2;
    private javax.swing.JTextField tfChave3;
    private javax.swing.JFormattedTextField tfDataCompra;
    private javax.swing.JTextField tfNParcelas;
    private javax.swing.JTextField tfPrecott;
    private javax.swing.JTextField tfValorEntrada;
    private javax.swing.JTabbedPane tpGuia;
    // End of variables declaration//GEN-END:variables
}

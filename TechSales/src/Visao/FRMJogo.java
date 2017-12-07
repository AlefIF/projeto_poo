/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.CategoriaControle;
import Controle.Con_JogoControle;
import Controle.ConsoleControle;
import Modelo.CategoriaBEAN;
import Modelo.CategoriaMysqlDAO;
import Modelo.ConsoleBEAN;
import Modelo.ConsoleMySqlDAO;
import Controle.JogoControle;
import Modelo.Con_jogoBEAN;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.JogoBEAN;
import Modelo.InsertBean;
import javax.swing.DefaultCellEditor;
import javax.swing.RowFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author LUCASP
 */
public class FRMJogo extends javax.swing.JFrame {

    private JogoControle jControle = new JogoControle();
    private Con_JogoControle cjc = new Con_JogoControle();
    private ConsoleControle cControle = new ConsoleControle();
    private CategoriaControle catControle = new CategoriaControle();
    private ArrayList<JogoBEAN> jDados;
    private ArrayList<CategoriaBEAN> catDados;
    private ArrayList<Con_jogoBEAN> cjDados;
    private ArrayList<ConsoleBEAN> cDados;
    private DefaultTableModel dTable;
    private DefaultTableModel dTable2;
    private ArrayList<InsertBean> insertDados = new ArrayList<InsertBean>();

    /**
     * Creates new form FRMJogo
     */
    //Notas
    //O pega selecionado não funciona quando se usa a pesquisa refinada 
    //Não consegui inserir os atributos de conosole na tabela, eles são de outro objeto
    //Não implementei a funcionalidade inserir por falta de tempo
    public FRMJogo() {
        initComponents();
        setResizable(false);

        ConsoleMySqlDAO consDAO = new ConsoleMySqlDAO();
        for (ConsoleBEAN e : consDAO.listarALL()) {
            cbCon.addItem(e);
        }
        CategoriaMysqlDAO catDAO = new CategoriaMysqlDAO();
        for (CategoriaBEAN d : catDAO.listarALL()) {
            cbCat.addItem(d);
        }

        preencheTabela();
    }

    private void preencheTabela() {
        dTable = criaTabela();
        //seta o nome das colunas da tabela
        dTable.addColumn("Código");
        dTable.addColumn("Nome");
        dTable.addColumn("Faixa Etária");
        dTable.addColumn("Preço Padrão");
        dTable.addColumn("Tipo de Jogo");
        dTable.addColumn("Categoria");
        dTable.addColumn("Console");
        dTable.addColumn("Lote");
        dTable.addColumn("Quantidade");
        //pega os dados do ArrayList
        jDados = jControle.listarALL();
        catDados = catControle.listarALL();
        cDados = cControle.listarALL();
        cjDados = cjc.listarALL();

        for (JogoBEAN dado : jDados) {
            for (CategoriaBEAN dado2 : catDados) {
                if (dado.getJo_catCodigo() == dado2.getCatCodigo()) {
                    for (Con_jogoBEAN dado3 : cjDados) {
                        if (dado3.getCjg_joCodigo() == dado.getJoCodigo()) {
                            for (ConsoleBEAN dado4 : cDados) {
                                if (dado3.getCjg_conCodigo() == dado4.getConCodigo()) {
                                    dTable.addRow(new Object[]{dado.getJoCodigo(), dado.getJoNome(),
                                        dado.getJoFaixaEtaria(), dado.getJoPrecoPadrao(), dado.getJoTipo(),
                                        dado2.getCatNome(), dado4.getConNome(), dado.getJoLote(), dado.getJoQtd()});
                                }
                            }
                        }
                    }
                }
            }
        }

        //set o modelo da tabela
        tableJogo.setModel(dTable);
        //TableColumn tc= tableJogo.getColumnModel().getColumn(7);
        // tc.setCellEditor(new DefaultCellEditor (cbCat));
    }

    private DefaultTableModel criaTabela() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel dTable = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
                java.lang.Double.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class};
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
        //retorna o DefaultTableModel
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox<>();
        tpGuia = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btLocalizar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbCon = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        tfPreco = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableM = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfQtde = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfLote = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cbCat = new javax.swing.JComboBox<>();
        tfFaixa = new javax.swing.JFormattedTextField();
        tfNome = new javax.swing.JTextField();
        lbCodigoJogo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJogo = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tfChave = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        btVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo");
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu de opções"));

        btCadastrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonAddJogo.png"))); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.setMaximumSize(new java.awt.Dimension(73, 23));
        btCadastrar.setMinimumSize(new java.awt.Dimension(73, 23));
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonEdit.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonDeletarFun.png"))); // NOI18N
        btExcluir.setText("Invalidar");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btLocalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonConsultarCliente.png"))); // NOI18N
        btLocalizar.setText("Localizar");
        btLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btEditar)
                .addGap(18, 18, 18)
                .addComponent(btLocalizar)
                .addGap(18, 18, 18)
                .addComponent(btExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar)
                    .addComponent(btExcluir)
                    .addComponent(btLocalizar))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Console :");

        cbCon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbCon.setToolTipText("");
        cbCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConActionPerformed(evt);
            }
        });

        jButton1.setText("inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPrecoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Preço :");

        tableM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableM.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableM);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Tipo de jogo :");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Venda", "Aluguel" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Quantidade :");

        tfQtde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQtdeKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Lote :");

        tfLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfLoteKeyTyped(evt);
            }
        });

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfQtde)
                            .addComponent(tfLote)
                            .addComponent(tfPreco)
                            .addComponent(cbCon, 0, 124, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jButton2))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        try{
            javax.swing.text.MaskFormatter faixa= new javax.swing.text.MaskFormatter("+(##)");
            tfFaixa = new javax.swing.JFormattedTextField(faixa);
        }
        catch (Exception e){
        }
        tfFaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFaixaActionPerformed(evt);
            }
        });
        tfFaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFaixaKeyTyped(evt);
            }
        });

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        lbCodigoJogo.setText("...");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Categoria :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Faixa etária :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Nome :");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Código :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbCodigoJogo))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(25, 25, 25)
                            .addComponent(tfFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(cbCat, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3))
                    .addContainerGap(159, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lbCodigoJogo))
                    .addGap(21, 21, 21)
                    .addComponent(jLabel3)
                    .addGap(16, 16, 16)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tfFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(cbCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        tpGuia.addTab("Cadastrar jogo", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Refinar pesquisa"));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel12.setText("Palavra Chave :");

        tfChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChaveActionPerformed(evt);
            }
        });
        tfChave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfChaveKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfChaveKeyTyped(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Venda");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Aluguel");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfChave)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpGuia.addTab("Consultar jogo", jPanel2);

        getContentPane().add(tpGuia);
        tpGuia.setBounds(20, 20, 520, 470);

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonLogin.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltar);
        btVoltar.setBounds(470, 10, 80, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Interface gráfica/back2.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-40, -30, 620, 560);

        setSize(new java.awt.Dimension(576, 534));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int retornaLinha() {
        //retorna a linha que o usuário selecionou na tabela
        int linha = tableJogo.getSelectedRow();
        return linha;
    }

    private int verificaLote() {
        int j = 0;
        jDados = jControle.listarALL();
        for (InsertBean insert : insertDados) {
            for (JogoBEAN jDado : jDados) {
                if (jDado.getJoLote().equals(insert.getJoLote())) {
                    j = jDado.getJoCodigo();
                }
            }
        }
        return j;
    }

    private int verificaLote1() {
        int j = 0;
        jDados = jControle.listarALL();
        for (JogoBEAN jDado : jDados) {
            if (jDado.getJoLote().equals(tfLote.getText())) {
                j = jDado.getJoCodigo();
            }
        }
        return j;
    }

    private void cadastroInserir() {
        cDados = cControle.listarALL();
        jDados = jControle.listarALL();
        for (InsertBean insert : insertDados) {
            for (ConsoleBEAN cDado : cDados) {
                if (cDado.getConNome().equals(insert.getConNome())) {
                    JogoBEAN jogo = new JogoBEAN();
                    jogo.setJoNome(tfNome.getText());
                    jogo.setJoFaixaEtaria(tfFaixa.getText());
                    CategoriaBEAN c = (CategoriaBEAN) cbCat.getSelectedItem();
                    jogo.setJo_catCodigo(c.getCatCodigo());
                    jogo.setJoPrecoPadrao(insert.getJoPrecoPadrao());
                    jogo.setJoQtd(insert.getJoQtd());
                    jogo.setJoLote(insert.getJoLote());
                    jogo.setJoTipo(insert.getJoTipo());
                    jControle.cadastrar(jogo);
                    Con_jogoBEAN w = new Con_jogoBEAN();
                    w.setCjg_conCodigo(cDado.getConCodigo());
                    cjc.cadastrar2(w);
                }
            }

        }
        resultado();
    }

    private int verificarInserir() {
        int j = 0;
        for (InsertBean insert : insertDados) {
            j++;
        }
        return j;
    }

    private void resultado() {
        insertDados.clear();
        preencheTabela2();
        this.preencheTabela();
        limparCampos();
        JOptionPane.showMessageDialog(null, "Jogo CADASTRADO com sucesso");
    }

    private void cadastroNormal() {
        JogoBEAN jogo = new JogoBEAN();
        jogo.setJoNome(tfNome.getText());
        jogo.setJoFaixaEtaria(tfFaixa.getText());
        CategoriaBEAN c = (CategoriaBEAN) cbCat.getSelectedItem();
        jogo.setJo_catCodigo(c.getCatCodigo());
        jogo.setJoPrecoPadrao(Float.parseFloat(tfPreco.getText()));
        jogo.setJoQtd(Integer.parseInt(tfQtde.getText()));
        jogo.setJoLote(tfLote.getText());
        jogo.setJoTipo(String.valueOf(cbTipo.getSelectedItem()));
        jControle.cadastrar(jogo);
        ConsoleBEAN w = (ConsoleBEAN) cbCon.getSelectedItem();
        Con_jogoBEAN a = new Con_jogoBEAN();
        a.setCjg_conCodigo(w.getConCodigo());
        cjc.cadastrar2(a);
        resultado();
    }

    private boolean verificaCampos() {
        if (tfFaixa.getText().equals("+(  )") || tfNome.getText().equals("")
                || tfFaixa.getText().equals("") || cbCat.getSelectedIndex() == (0)
                || tfPreco.getText().equals("") || tfQtde.getText().equals("")
                || tfLote.getText().equals("") || cbCon.getSelectedIndex() == (0)
                || cbTipo.getSelectedIndex() == (0)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean verificaCampos2() {
        if (tfFaixa.getText().equals("+(  )")
                || tfNome.getText().equals("") || tfFaixa.getText().equals("")
                || cbCat.getSelectedIndex() == (0)) {
            return false;
        } else {
            return true;
        }
    }
    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        if (verificaCampos2()) {
            int z = verificarInserir();
            if (z == 0) {
                int v = verificaLote1();
                if (v == 0) {
                    this.cadastroNormal();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro! Lote já existente,Código do produto:" + v);
                }
            } else {
                int x = verificaLote();
                if (x == 0) {
                    this.cadastroInserir();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro! Lote já existente,Código do produto:" + x);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Insira todos os valores");
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        if (verificaCampos() == true) {
            JogoBEAN jogo = new JogoBEAN();
            jogo.setJoCodigo(Integer.parseInt(lbCodigoJogo.getText()));
            jogo.setJoNome(tfNome.getText());
            jogo.setJoDisponibilidade(0);
            jogo.setJoFaixaEtaria(tfFaixa.getText());
            jogo.setJoPrecoPadrao(Float.parseFloat((tfPreco.getText())));
            jogo.setJoTipo(String.valueOf(cbTipo.getSelectedItem()));
            jogo.setJoQtd(Integer.parseInt(String.valueOf(tfQtde.getText())));
            jogo.setJoLote(String.valueOf(tfLote.getText()));
            CategoriaBEAN c = (CategoriaBEAN) cbCat.getSelectedItem();
            jogo.setJo_catCodigo(c.getCatCodigo());
            Con_jogoBEAN w = new Con_jogoBEAN();
            ConsoleBEAN d = (ConsoleBEAN) cbCon.getSelectedItem();
            w.setCjg_joCodigo(Integer.parseInt(lbCodigoJogo.getText()));
            w.setCjg_conCodigo(d.getConCodigo());
            //chama o método de controle para editar
            boolean retorno1 = cjc.editar2(w);
            if (retorno1 == true) {
                boolean retorno = jControle.editar(jogo);
                //se a variavel retorno for igual a true o usuario foi editado
                if (retorno == true) {
                    JOptionPane.showMessageDialog(null, "Jogo MODIFICADO com sucesso");
                    //solicita a atualização da tabela ou seja preenche ela toda novamente
                    this.preencheTabela();
                    //chama o método para limpar campos
                    this.limparCampos();
                } else {
                    //mensagem de erro
                    JOptionPane.showMessageDialog(null, "ERRO na EDIÇÃO");
                }
            } else {
                //mensagem de erro
                JOptionPane.showMessageDialog(null, "ERRO na EDIÇÃO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Insira todos os valores");
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (verificaCampos() == true) {
            JogoBEAN jogo = new JogoBEAN();
            jogo.setJoCodigo(Integer.parseInt(lbCodigoJogo.getText()));
            jogo.setJoQtd(0);
            jogo.setJoDisponibilidade(1);
            boolean retorno = jControle.editarINVAL(jogo);
            //se a variavel retorno for igual a true o usuario foi editado
            if (retorno == true) {
                JOptionPane.showMessageDialog(null, "Jogo MODIFICADO com sucesso");
                //solicita a atualização da tabela ou seja preenche ela toda novamente
                this.preencheTabela();
                //chama o método para limpar campos
                this.limparCampos();
            } else {
                //mensagem de erro
                JOptionPane.showMessageDialog(null, "ERRO na EDIÇÃO");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Erro! Insira todos os valores");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalizarActionPerformed
        tpGuia.setSelectedIndex(1);
        preencheTabela();
    }//GEN-LAST:event_btLocalizarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        FRMPrincipalFun fun = new FRMPrincipalFun();
        this.dispose();
        fun.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tableJogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableJogoMouseClicked
        limparCampos();
        tpGuia.setSelectedIndex(0);
        if (tableJogo.getSelectedRow() != -1) {
            if (Integer.parseInt(tableJogo.getValueAt(tableJogo.getSelectedRow(), 8).toString()) > 0) {
                lbCodigoJogo.setText(tableJogo.getValueAt(tableJogo.getSelectedRow(), 0).toString());
                tfNome.setText(tableJogo.getValueAt(tableJogo.getSelectedRow(), 1).toString());
                tfFaixa.setText(tableJogo.getValueAt(tableJogo.getSelectedRow(), 2).toString());
                tfPreco.setText((tableJogo.getValueAt(tableJogo.getSelectedRow(), 3).toString()));
                cbTipo.setSelectedItem(tableJogo.getValueAt(tableJogo.getSelectedRow(), 4).toString());
                for (CategoriaBEAN dado2 : catDados) {
                    if ((tableJogo.getValueAt(tableJogo.getSelectedRow(), 5).toString().equals(dado2.getCatNome()))) {
                        cbCat.setSelectedIndex(dado2.getCatCodigo());
                    }
                }
                for (ConsoleBEAN dado4 : cDados) {
                    if ((tableJogo.getValueAt(tableJogo.getSelectedRow(), 6).toString().equals(dado4.getConNome()))) {
                        cbCon.setSelectedIndex(dado4.getConCodigo());
                    }
                }
                tfLote.setText(tableJogo.getValueAt(tableJogo.getSelectedRow(), 7).toString());
                tfQtde.setText(tableJogo.getValueAt(tableJogo.getSelectedRow(), 8).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Erro, jogo não disponível no estoque");
            }
        }
    }//GEN-LAST:event_tableJogoMouseClicked

    private void tfFaixaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFaixaKeyTyped
        String caracteres = "0123456789+";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfFaixaKeyTyped

    private void tfPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoKeyTyped
        String caracteres = "0123456789.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfPrecoKeyTyped

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void tfFaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFaixaActionPerformed

    private void tfQtdeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtdeKeyTyped
        String caracteres = "0123456789";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfQtdeKeyTyped

    private void cbConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConActionPerformed

    }//GEN-LAST:event_cbConActionPerformed

    private void tfChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChaveKeyPressed

    }//GEN-LAST:event_tfChaveKeyPressed

    private void tfChaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChaveKeyTyped
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) tableJogo.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        tableJogo.setRowSorter(sorter);
        String text = tfChave.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_tfChaveKeyTyped

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) tableJogo.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        tableJogo.setRowSorter(sorter);
        String text = "Venda";
        sorter.setRowFilter(RowFilter.regexFilter(text));
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) tableJogo.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        tableJogo.setRowSorter(sorter);
        String text = "Aluguel";
        sorter.setRowFilter(RowFilter.regexFilter(text));
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void preencheTabela2() {
        dTable2 = criaTabela2();
        dTable2.addColumn("Preço Padrão");
        dTable2.addColumn("Tipo de Jogo");
        dTable2.addColumn("Console");
        dTable2.addColumn("Lote");
        dTable2.addColumn("Quantidade");

        for (InsertBean as : insertDados) {
            dTable2.addRow(new Object[]{as.getJoPrecoPadrao(), as.getJoTipo(),
                as.getConNome(), as.getJoLote(), as.getJoQtd()});
        }

        //set o modelo da tabela
        tableM.setModel(dTable2);
    }

    private DefaultTableModel criaTabela2() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel dTable2 = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Double.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.Integer.class};
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
        //retorna o DefaultTableModel
    return dTable2;
    }

    private void cadastroTeste() {
        InsertBean jogo = new InsertBean();
        jogo.setJoPrecoPadrao(Float.parseFloat((tfPreco.getText())));
        jogo.setJoTipo(String.valueOf(cbTipo.getSelectedItem()));

        ConsoleBEAN w = (ConsoleBEAN) cbCon.getSelectedItem();
        jogo.setConNome(w.getConNome());

        jogo.setJoLote(tfLote.getText());
        jogo.setJoQtd(Integer.parseInt(tfQtde.getText()));
        insertDados.add(jogo);
    }

    private void limparCampos2() {
        tfLote.setText("");
        tfPreco.setText("");
        tfQtde.setText("");
        cbCon.setSelectedIndex(0);
        cbTipo.setSelectedIndex(0);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        cadastroTeste();
        preencheTabela2();
        limparCampos2();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLoteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLoteKeyTyped

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int i = tableM.getSelectedRow();
        if (i != -1) {
            insertDados.remove(i);
            preencheTabela2();
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Nenhum dado selecionado na tabela");

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMMouseClicked
        int i = tableM.getSelectedRow();
    }//GEN-LAST:event_tableMMouseClicked

    private void tfChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChaveActionPerformed
    private void limparCampos() {
        lbCodigoJogo.setText("");
        tfNome.setText("");
        tfFaixa.setText("");
        tfPreco.setText("");
        tfQtde.setText("");
        cbCat.setSelectedIndex(0);
        cbCon.setSelectedIndex(0);
        cbTipo.setSelectedIndex(0);
        tfLote.setText("");
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
            java.util.logging.Logger.getLogger(FRMJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLocalizar;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Object> cbCat;
    private javax.swing.JComboBox<Object> cbCon;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbCodigoJogo;
    private javax.swing.JTable tableJogo;
    private javax.swing.JTable tableM;
    private javax.swing.JTextField tfChave;
    private javax.swing.JFormattedTextField tfFaixa;
    private javax.swing.JTextField tfLote;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tfPreco;
    private javax.swing.JTextField tfQtde;
    private javax.swing.JTabbedPane tpGuia;
    // End of variables declaration//GEN-END:variables

}

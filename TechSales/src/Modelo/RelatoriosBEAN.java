/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.ContaAPrazoControle;
import Controle.ContaControle;
import Controle.ControleRelatorios;
import Controle.JogoLocacaoControle;
import Controle.LocacaoControle;
import Controle.NotaDeCompraAPrazoControle;
import Controle.NotaDeCompraControle;
import Controle.VendaAPrazoControle;
import Visao.FRMEmitirRelatorios;
import Visao.FRMLogin;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Alef
 */
public class RelatoriosBEAN {

    static ControleRelatorios jDAO = new ControleRelatorios();
    static NotaDeCompraControle cNdc = new NotaDeCompraControle();
    static NotaDeCompraAPrazoControle cNdcap = new NotaDeCompraAPrazoControle();
    static ContaControle cContas = new ContaControle();
    static ContaAPrazoControle cCap = new ContaAPrazoControle();
    static VendaAPrazoControle cVap = new VendaAPrazoControle();
    static JogoLocacaoControle cJl = new JogoLocacaoControle();
    static LocacaoControle contL = new LocacaoControle();

    public static void relatorioTopJogos() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<br/>"
                    + "<h1 align=center>Relatório de Jogos mais vendidos</h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Nome do Jogo</strong></th> "
                    + "<th align=center><strong>Quantidade Vendida</strong></th> "
                    + "<th align=center><strong>Valor Total</strong></th> "
                    + "</tr> ";
            for (JogoBEAN j : jDAO.topJogos()) {
                frase += "<tr align=center><td>" + j.getJoCodigo() + "</td><td>"
                        + j.getJoNome() + "</td><td>" + j.getJoQtd() + "</td><td>" + j.getJoPrecoPadrao() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void relatorioWorstJogos() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<br/>"
                    + "<h1 align=center>Relatório de Jogos menos vendidos </h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Nome do Jogo</strong></th> "
                    + "<th align=center><strong>Quantidade Vendida</strong></th> "
                    + "<th align=center><strong>Valor Total</strong></th> "
                    + "</tr> ";
            for (JogoBEAN j : jDAO.worstJogos()) {
                frase += "<tr align=center><td>" + j.getJoCodigo() + "</td><td>"
                        + j.getJoNome() + "</td><td>" + j.getJoQtd() + "</td><td>" + j.getJoPrecoPadrao() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void relatorioTopAlugueis() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<br/>"
                    + "<h1 align=center>Relatório de Jogos mais Alugados </h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Nome do Jogo</strong></th> "
                    + "<th align=center><strong>Quantidade Alugada</strong></th> "
                    + "<th align=center><strong>Valor Total</strong></th> "
                    + "</tr> ";
            for (JogoBEAN j : jDAO.topAluguelJogos()) {
                frase += "<tr align=center><td>" + j.getJoCodigo() + "</td><td>"
                        + j.getJoNome() + "</td><td>" + j.getJoQtd() + "</td><td>" + j.getJoPrecoPadrao() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void relatorioWorstAlugueis() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<br/>"
                    + "<h1 align=center>Relatório de Jogos menos Alugados </h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Nome do Jogo</strong></th> "
                    + "<th align=center><strong>Quantidade Vendida</strong></th> "
                    + "<th align=center><strong>Valor Total</strong></th> "
                    + "</tr> ";
            for (JogoBEAN j : jDAO.topAluguelJogos()) {
                frase += "<tr align=center><td>" + j.getJoCodigo() + "</td><td>"
                        + j.getJoNome() + "</td><td>" + j.getJoQtd() + "</td><td>" + j.getJoPrecoPadrao() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*-----------------------------------*/
    public static void relatorioCompras() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<br/>"
                    + "<h1 align=center>Relatório de Jogos Comprados </h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Custo Unitário</strong></th> "
                    + "<th align=center><strong>Data</strong></th> "
                    + "<th align=center><strong>Valor da Entrada</strong></th> "
                    + "<th align=center><strong>Número de parcelas</strong></th> "
                    + "<th align=center><strong>Preço Total</strong></th> "
                    + "<th align=center><strong>Quantidade Compradra</strong></th> "
                    + "<th align=center><strong>Caixa</strong></th> "
                    + "<th align=center><strong>Jogo</strong></th> "
                    + "</tr> ";
            for (NotaDecompraBEAN n : cNdc.listarALL()) {
                frase += "<tr align=center><td>" + n.getNdcCodigo() + "</td><td>"
                        + n.getNdcCustoUnitario() + "</td><td>" + n.getNdcData() + "</td><td>" + n.getNdcEntrada() + "</td><td>"
                        + n.getNdcParcelas() + "</td><td>" + n.getNdcPrecoTotal() + "</td><td>" + n.getNdcQtdComprada()
                        + "</td><td>" + n.getCaixa().getCaixaCodigo() + "</td><td>" + n.getJogo().getJoNome() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*-----------------------------------------*/
    public static void relatorioContas() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<br/>"
                    + "<h1 align=center>Relatório de Contas </h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Data</strong></th> "
                    + "<th align=center><strong>Valor da Entrada</strong></th> "
                    + "<th align=center><strong>Número de parcelas</strong></th> "
                    + "<th align=center><strong>Preço Total</strong></th> "
                    + "<th align=center><strong>Descrição</strong></th> "
                    + "<th align=center><strong>Fornecedor</strong></th> "
                    + "<th align=center><strong>Caixa</strong></th> "
                    + "</tr> ";
            for (ContaBEAN n : cContas.listarALL()) {
                frase += "<tr align=center><td>" + n.getConCodigo() + "</td><td>"
                        + n.getConData() + "</td><td>" + n.getConEntrada() + "</td><td>"
                        + n.getConNparcelas() + "</td><td>" + n.getConValorTotal()
                        + "</td><td>" + n.getConDescricao() + "</td><td>" + n.getFornecedor().getForNomeEmpresa()
                        + "</td><td>" + n.getCaixa().getCaixaCodigo() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*----------------------------------*/
    public static void relatorioMontanteVendedor() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<br/>"
                    + "<h1 align=center>Relatório de montante por vendedor</h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código do funcionario</strong></th> "
                    + "<th align=center><strong>Nome do funcionario</strong></th> "
                    + "<th align=center><strong>Número de vendas</strong></th> "
                    + "<th align=center><strong>Valor total das vendas</strong></th> "
                    + "<th align=center><strong>Quantidade de alugueis</strong></th> "
                    + "<th align=center><strong>Valor total de alugueis</strong></th> "
                    + "<th align=center><strong>Montante Total</strong></th> "
                    + "</tr> ";
            for (MontanteBEAN j : jDAO.montanteVendedor()) {
                frase += "<tr align=center><td>" + j.getFunCodigo() + "</td><td>"
                        + j.getFunNome() + "</td><td>" + j.getnVendas() + "</td><td>"
                        + j.getValorVendas() + "</td><td>" + j.getnAluguel()
                        + "</td><td>" + j.getValorAluguel() + "</td><td>" + j.getValorTotal() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*----------------------------------------*/
    public static void relatorioVendaJogoPeriodo(String s, String dI, String dF) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Relatório de Jogos vendidos</h1>"
                    + "<br/>"
                    + "<h3 align=center>Período de " + dI + " a " + dF + "</h3>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código do jogo</strong></th> "
                    + "<th align=center><strong>Nome do jogo</strong></th> "
                    + "<th align=center><strong>Número de vendas</strong></th> "
                    + "<th align=center><strong>Valor total das vendas</strong></th> "
                    + "</tr> ";
            for (JogoBEAN j : jDAO.vendaPorPeriodo(s)) {
                frase += "<tr align=center><td>" + j.getJoCodigo() + "</td><td>"
                        + j.getJoNome() + "</td><td>" + j.getJoQtd() + "</td><td>"
                        + j.getJoPrecoPadrao() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*---------------------------------*/
    public static void relatorioAluguelJogoPeriodo(String s, String dI, String dF) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<br/>"
                    + "<h1 align=center>Relatório de Jogos alugados</h1>"
                    + "<h3 align=center>Período de " + dI + " a " + dF + "</h3>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código do jogo</strong></th> "
                    + "<th align=center><strong>Nome do jogo</strong></th> "
                    + "<th align=center><strong>Número de alugueis</strong></th> "
                    + "<th align=center><strong>Valor total dos alugueis</strong></th> "
                    + "</tr> ";
            for (JogoBEAN j : jDAO.aluguelPorPeriodo(s)) {
                frase += "<tr align=center><td>" + j.getJoCodigo() + "</td><td>"
                        + j.getJoNome() + "</td><td>" + j.getJoQtd() + "</td><td>"
                        + j.getJoPrecoPadrao() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*------------------------------------------------------*/
    public static void relatorioMontanteCliente() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<br/>"
                    + "<h1 align=center>Relatório de montante por cliente </h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código do cliente</strong></th> "
                    + "<th align=center><strong>Nome do cliente</strong></th> "
                    + "<th align=center><strong>Número de compras</strong></th> "
                    + "<th align=center><strong>Valor total das compras</strong></th> "
                    + "<th align=center><strong>Quantidade de alugueis</strong></th> "
                    + "<th align=center><strong>Valor total de alugueis</strong></th> "
                    + "<th align=center><strong>Montante Total</strong></th> "
                    + "</tr> ";
            for (MontanteBEAN j : jDAO.montanteCliente()) {
                frase += "<tr align=center><td>" + j.getFunCodigo() + "</td><td>"
                        + j.getFunNome() + "</td><td>" + j.getnVendas() + "</td><td>"
                        + j.getValorVendas() + "</td><td>" + j.getnAluguel()
                        + "</td><td>" + j.getValorAluguel() + "</td><td>" + j.getValorTotal() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*------------------*/
    public static void notaDaVenda(VendaBEAN v) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Nota de Compra</h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Cliente</strong></th> "
                    + "<th align=center><strong>Data</strong></th> "
                    + "<th align=center><strong>Total</strong></th> "
                    + "<th align=center><strong>Entrada</strong></th> "
                    + "<th align=center><strong>Parcelas</strong></th> "
                    + "<th align=center><strong>Vendedor</strong></th> "
                    + "</tr> ";

            frase += "<tr align=center><td>" + v.getVendaCodigo() + "</td><td>"
                    + v.getCliente().getCliCodigo() + "</td><td>" + v.getVendaData() + "</td><td>"
                    + "</td><td>" + v.getVendaValorTotal() + "</td><td>"
                    + "</td><td>" + v.getVendaEntrada() + "</td><td>"
                    + "</td><td>" + v.getVendaNparcelas() + "</td><td>"
                    + "</td><td>" + v.getVendedor().getVendedorCodigo() + "</td></tr>"
                    + "</table>";

            frase += "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<br/><br/>"
                    + "<tr> "
                    + "<th align=center><strong>Parcela</strong></th> "
                    + "<th align=center><strong>Data</strong></th> "
                    + "<th align=center><strong>Valor</strong></th> "
                    + "<th align=center><strong>Situação</strong></th> "
                    + "</tr> ";

            for (VendaAPrazoBEAN vap : cVap.listarALL()) {
                if (vap.getVenda().getVendaCodigo() == v.getVendaCodigo()) {
                    frase += "<tr align=center><td>" + vap.getVapNumParcela() + "</td><td>"
                            + vap.getVapData() + "</td><td>"
                            + vap.getVapValorParcela() + "</td><td>"
                            + vap.getVapSituacao() + "</td></tr>";
                }
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*--------------------------*/
 /*------------------*/
    public static void notaDoAluguel(LocacaoBEAN l) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Nota de aluguel</h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Cliente</strong></th> "
                    + "<th align=center><strong>Data Locação</strong></th> "
                    + "<th align=center><strong>Data Devolução</strong></th> "
                    + "<th align=center><strong>Total</strong></th> "
                    + "<th align=center><strong>Entrada</strong></th> "
                    + "<th align=center><strong>Preço Unit.</strong></th> "
                    + "<th align=center><strong>Situação</strong></th> "
                    + "<th align=center><strong>Vendedor</strong></th> "
                    + "</tr> ";

            frase += "<tr align=center><td>" + l.getLocCodigo() + "</td><td>"
                    + l.getCliente().getCliNome() + "</td><td>" + l.getLocDataAluguel() + "</td><td>"
                    + l.getLocDataDevolucao() + "</td><td>" + l.getLocPreçoTotal() + "</td><td>"
                    + l.getLocEntrada() + "</td><td>" + l.getLocPrecoUnit() + "</td><td>"
                    + l.getLocStatus() + "</td><td>" + l.getVendedor().getFuncionario().getFunNome() + "</td></tr>"
                    + "</table>";

            frase += "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<br/><br/>"
                    + "<tr> "
                    + "<th align=center><strong>Código do Jogo</strong></th> "
                    + "<th align=center><strong>Nome</strong></th> "
                    + "<th align=center><strong>Quantidade Locação</strong></th> "
                    + "</tr> ";
            for (JogoLocacaoBEAN jl : cJl.listarALL()) {
                if (jl.getChaveComposta().getLocacao().getLocCodigo() == l.getLocCodigo()) {
                    frase += "<tr align=center><td>" + jl.getChaveComposta().getJogo().getJoCodigo() + "</td><td>"
                            + jl.getChaveComposta().getJogo().getJoNome() + "</td><td>"
                            + jl.getJlQtd() + "</td></tr>";
                }
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*------------------*/
    public static void notaDaDev(DevolucaoBEAN l) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Nota de devolução</h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Cliente</strong></th> "
                    + "<th align=center><strong>Data Devolução</strong></th> "
                    + "<th align=center><strong>Multa</strong></th> "
                    + "<th align=center><strong>Valor Total</strong></th> "
                    + "<th align=center><strong>Vendedor</strong></th> "
                    + "</tr> ";

            frase += "<tr align=center><td>" + l.getDevCodigo() + "</td><td>"
                    + l.getLocacao().getCliente().getCliNome() + "</td><td>" + l.getDevData() + "</td><td>"
                    + l.getDevMulta() + "</td><td>" + l.getDevValor() + "</td><td>"
                    + l.getLocacao().getVendedor().getFuncionario().getFunNome() + "</td></tr>"
                    + "</table>";

            frase += "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<br/><br/>"
                    + "<tr> "
                    + "<th align=center><strong>Código do Jogo</strong></th> "
                    + "<th align=center><strong>Nome</strong></th> "
                    + "<th align=center><strong>Quantidade Locação</strong></th> "
                    + "</tr> ";
            for (JogoLocacaoBEAN jl : cJl.listarALL()) {
                if (jl.getChaveComposta().getLocacao().getLocCodigo() == l.getLocacao().getLocCodigo()) {
                    frase += "<tr align=center><td>" + jl.getChaveComposta().getJogo().getJoCodigo() + "</td><td>"
                            + jl.getChaveComposta().getJogo().getJoNome() + "</td><td>"
                            + jl.getJlQtd() + "</td></tr>";
                }
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*------------------*/
    public static void notaDeConta(ContaBEAN v) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Nota de Conta</h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Fornecedor</strong></th> "
                    + "<th align=center><strong>Data</strong></th> "
                    + "<th align=center><strong>Total</strong></th> "
                    + "<th align=center><strong>Entrada</strong></th> "
                    + "<th align=center><strong>Parcelas</strong></th> "
                    + "</tr> ";

            frase += "<tr align=center><td>" + v.getConCodigo() + "</td><td>"
                    + v.getFornecedor().getForNomeEmpresa() + "</td><td>" + v.getConData() + "</td><td>"
                    + v.getConValorTotal() + "</td><td>"
                    + v.getConEntrada() + "</td><td>"
                    + v.getConNparcelas() + "</td></tr>"
                    + "</table>";

            frase += "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<br/><br/>"
                    + "<tr> "
                    + "<th align=center><strong>Parcela</strong></th> "
                    + "<th align=center><strong>Data</strong></th> "
                    + "<th align=center><strong>Valor</strong></th> "
                    + "<th align=center><strong>Situação</strong></th> "
                    + "</tr> ";

            for (ContaAPrazoBEAN vap : cCap.listarALL()) {
                if (vap.getConta().getConCodigo() == v.getConCodigo()) {
                    frase += "<tr align=center><td>" + vap.getCapNumParcela() + "</td><td>"
                            + vap.getCapData() + "</td><td>"
                            + vap.getCapValorParcela() + "</td><td>"
                            + vap.getCapSituacao() + "</td></tr>";
                }
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*--------------------------*/
    public static void notaDeCompra(NotaDecompraBEAN n) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + FRMEmitirRelatorios.local + ".pdf";
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<br/>"
                    + "<h1 align=center>Relatório de Jogos Comprados </h1>"
                    + "<br/><br/>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Custo Unitário</strong></th> "
                    + "<th align=center><strong>Data</strong></th> "
                    + "<th align=center><strong>Valor da Entrada</strong></th> "
                    + "<th align=center><strong>Número de parcelas</strong></th> "
                    + "<th align=center><strong>Preço Total</strong></th> "
                    + "<th align=center><strong>Quantidade Compradra</strong></th> "
                    + "<th align=center><strong>Caixa</strong></th> "
                    + "<th align=center><strong>Jogo</strong></th> "
                    + "</tr> ";

            frase += "<tr align=center><td>" + n.getNdcCodigo() + "</td><td>"
                    + n.getNdcCustoUnitario() + "</td><td>" + n.getNdcData() + "</td><td>" + n.getNdcEntrada() + "</td><td>"
                    + n.getNdcParcelas() + "</td><td>" + n.getNdcPrecoTotal() + "</td><td>" + n.getNdcQtdComprada()
                    + "</td><td>" + n.getCaixa().getCaixaCodigo() + "</td><td>" + n.getJogo().getJoNome() + "</td></tr>"
                    + "</table>";;

            frase += "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<br/><br/>"
                    + "<tr> "
                    + "<th align=center><strong>Parcela</strong></th> "
                    + "<th align=center><strong>Data</strong></th> "
                    + "<th align=center><strong>Valor</strong></th> "
                    + "<th align=center><strong>Situação</strong></th> "
                    + "</tr> ";

            for (NotaDeCompraPrazoBEAN nap : cNdcap.listarALL()) {
                if (nap.getNota().getNdcCodigo() == n.getNdcCodigo()) {
                    frase += "<tr align=center><td>" + nap.getNapNumParcela() + "</td><td>"
                            + nap.getNapData() + "</td><td>"
                            + nap.getNapValor() + "</td><td>"
                            + nap.getNapSituacao() + "</td></tr>";
                }
            }

            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

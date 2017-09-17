/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import net.sf.jasperreports.engine.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import static Modelo.ConnectionFactory.getConnection;
import jxl.write.DateTime;

/**
 *
 * @author Alef
 */
public class GeraRelatorio2 {
    
    public GeraRelatorio2() {
    }

    //Método responsável por gerar o relatório
    public static void gerarRelatorio(String jrxml, String nomeArquivo, HashMap param) {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        //Try Catch necessário caso ocorra algum erro durante a geração do relatório
        
        try {
           //Formatando a data para nomear o arquivo PDF gerado
            SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
            //Pega a conexão para efetuar as operações no BD
            Connection con = getConnection();
            Map parameters = param;
            //Busca o relatório .jrxml
            JasperReport report = JasperCompileManager.compileReport("src/relatorios/" + jrxml + ".jrxml");
            //Chama o relatório passando o caminho, parâmtros especificados e a conexão com o BD
            JasperPrint impressao = JasperFillManager.fillReport(report, parameters, con);
            //Após ser gerado, a próxima linha exportará o documento em formato PDF
            JasperExportManager.exportReportToPdfFile(impressao, "src/relatorios/" + jrxml + "-" + dt.format(Calendar.getInstance().getTime()) + ".pdf");
            //Busca e exibe automaticamnete o arquivo PDF gerado
            File arquivo = new File("C:\\Users\\Alef\\Desktop\\projeto techsales poo\\TechSales\\src\\relatorios" + jrxml + "-" + dt.format(Calendar.getInstance().getTime()) + ".pdf");
            Desktop.getDesktop().open(arquivo);
           
        } catch (IOException | JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar o Relatório, " + e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.getMessage());
        }

    }
    
     
    public static void geraRelatorioJogos(Timestamp dataInicio,Timestamp dataFinal){
        HashMap parameters = new HashMap();
        parameters.put("dataInicio", dataInicio);
        parameters.put("dataFinal", dataFinal);
        gerarRelatorio("TopJogosPorPeriodo","TopJogosPorPeriodo",parameters);
    }

    
}

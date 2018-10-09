/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.CaixaBEAN;
import Modelo.JogoBEAN;
import Modelo.NotaDecompraBEAN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alef
 */
public class ControleRelatorios {

    //armazernar meu objeto de conexao com o BD MySQL    
    private Connection connection;
    //objeto stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public ControleRelatorios() {
        //inicializa a conexão com o BD - chamando o FActory e Singleton
        this.connection = ConnectionFactory.getConnection();
    }

    public ArrayList<JogoBEAN> topJogos() {
        String sql = "SELECT \n"
                + "    joCodigo, joNome, SUM(jvQdt) AS 'NVendas',sum(vendaValorTotal)'Valor total de Venda'\n"
                + "FROM\n"
                + "    jogo\n"
                + "        JOIN\n"
                + "    jogo_venda\n"
                + "    	JOIN\n"
                + "    venda  \n"
                + "WHERE\n"
                + "    joCodigo = joCod\n"
                + "			AND\n"
                + "	venCod = vendaCodigo\n"
                + "GROUP BY joCodigo\n"
                + "ORDER BY NVendas desc\n"
                + "LIMIT 10;";
        ArrayList<JogoBEAN> jogoAL = new ArrayList<JogoBEAN>();
        try {
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                JogoBEAN c = new JogoBEAN();
                c.setJoCodigo(rs.getInt("joCodigo"));
                c.setJoNome(rs.getString(2));
                c.setJoQtd(rs.getInt(3));
                c.setJoPrecoPadrao(rs.getFloat(4));
                jogoAL.add(c);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jogoAL;
    }

    /*------------------------*/
    public ArrayList<JogoBEAN> worstJogos() {
        String sql = "SELECT \n"
                + "    joCodigo, joNome, SUM(jvQdt) AS 'NVendas',sum(vendaValorTotal)'Valor total de Venda'\n"
                + "FROM\n"
                + "    jogo\n"
                + "        JOIN\n"
                + "    jogo_venda\n"
                + "		JOIN\n"
                + "    venda    \n"
                + "WHERE\n"
                + "    joCodigo = joCod\n"
                + "			AND\n"
                + "	venCod = vendaCodigo\n"
                + "GROUP BY joCodigo\n"
                + "ORDER BY NVendas asc\n"
                + "LIMIT 10;";
        ArrayList<JogoBEAN> jogoAL = new ArrayList<JogoBEAN>();
        try {
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                JogoBEAN c = new JogoBEAN();
                c.setJoCodigo(rs.getInt("joCodigo"));
                c.setJoNome(rs.getString(2));
                c.setJoQtd(rs.getInt(3));
                c.setJoPrecoPadrao(rs.getFloat(4));
                jogoAL.add(c);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jogoAL;
    }

    /*-----------------------------------*/
    public ArrayList<JogoBEAN> topAluguelJogos() {
        String sql = "SELECT \n"
                + "    joCodigo, joNome, SUM(jlQtd) AS 'NAlocações',sum(devValor) AS 'Valor Total'\n"
                + "FROM\n"
                + "    jogo\n"
                + "        JOIN\n"
                + "    jogo_locacao\n"
                + "		JOIN \n"
                + "	locacao\n"
                + "		JOIN\n"
                + "	devolucao\n"
                + "WHERE\n"
                + "    joCodigo = joCod\n"
                + "			AND\n"
                + "	locCod=locCodigo\n"
                + "			AND\n"
                + "	locCodigo=dev_locCodigo\n"
                + "GROUP BY joCodigo\n"
                + "ORDER BY NAlocações desc\n"
                + "LIMIT 10;";
        ArrayList<JogoBEAN> jogoAL = new ArrayList<JogoBEAN>();
        try {
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                JogoBEAN c = new JogoBEAN();
                c.setJoCodigo(rs.getInt("joCodigo"));
                c.setJoNome(rs.getString(2));
                c.setJoQtd(rs.getInt(3));
                c.setJoPrecoPadrao(rs.getFloat(4));
                jogoAL.add(c);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jogoAL;
    }

    /*-----------------------------------*/
    public ArrayList<JogoBEAN> worstAluguelJogos() {
        String sql = "SELECT \n"
                + "    joCodigo, joNome, SUM(jlQtd) AS 'NAlocações',sum(devValor) AS 'Valor Total'\n"
                + "FROM\n"
                + "    jogo\n"
                + "        JOIN\n"
                + "    jogo_locacao\n"
                + "		JOIN \n"
                + "	locacao\n"
                + "		JOIN\n"
                + "	devolucao\n"
                + "WHERE\n"
                + "    joCodigo = joCod\n"
                + "			AND\n"
                + "	locCod=locCodigo\n"
                + "			AND\n"
                + "	locCodigo=dev_locCodigo\n"
                + "GROUP BY joCodigo\n"
                + "ORDER BY NAlocações asc\n"
                + "LIMIT 10;";
        ArrayList<JogoBEAN> jogoAL = new ArrayList<JogoBEAN>();
        try {
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                JogoBEAN c = new JogoBEAN();
                c.setJoCodigo(rs.getInt("joCodigo"));
                c.setJoNome(rs.getString(2));
                c.setJoQtd(rs.getInt(3));
                c.setJoPrecoPadrao(rs.getFloat(4));
                jogoAL.add(c);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jogoAL;
    }
  
    /*---------------------------------------*/
    public ArrayList<JogoBEAN> montanteVendedor() {
        String sql = "SELECT \n"
                + "	funCodigo,funNome,count(vendaCodigo)as 'NumeroDeVendas',\n"
                + "    sum(vendaValorTotal) as 'Valor total de Vendas' ,\n"
                + "    count(locCodigo) 'Quantidade de alugueis',sum(devValor)as 'Valor total de Alugueis'\n"
                + "    ,('Valor total de Vendas'+'Valor total de Alugueis') as 'MontanteTotal'\n"
                + "FROM \n"
                + "	funcionario JOIN vendedor JOIN venda JOIN locacao JOIN devolucao\n"
                + "WHERE \n"
                + "	funCodigo=vendedor_funCodigo AND vendedorCodigo=venda_vendedorCodigo\n"
                + "    AND  loc_vendedorCodigo=vendedorCodigo and locCodigo=dev_locCodigo\n"
                + "GROUP BY \n"
                + "	funCodigo\n"
                + "ORDER BY\n"
                + "	MontanteTotal desc;";
        ArrayList<JogoBEAN> jogoAL = new ArrayList<JogoBEAN>();
        try {
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                JogoBEAN c = new JogoBEAN();
                c.setJoCodigo(rs.getInt("joCodigo"));
                c.setJoNome(rs.getString(2));
                c.setJoQtd(rs.getInt(3));
                c.setJoPrecoPadrao(rs.getFloat(4));
                jogoAL.add(c);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jogoAL;
    }
}

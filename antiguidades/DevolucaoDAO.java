/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Maycon Jonathan
 */
public class DevolucaoDAO {

    //armazena o obj de conexão com o BD mySql
    private Connection connection;
    //obj stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public DevolucaoDAO() {
        //inicializa a conexão com o BD
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(DevolucaoBEAN d) {
        String sql = "insert into devolucao (dev_funCodigo,dev_loCodigo,dev_cliCodigo,devDataDevolucao,devPreco,devMulta,dev_NotaFiscal)" + "values (?,?,?,?,?,?,?)";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setInt(1, d.getDev_funCodigo());
            stmt.setInt(2, d.getDev_loCodigo());
            stmt.setInt(3, d.getDev_cliCodigo());
            stmt.setDate(4, d.getDataDev());
            stmt.setFloat(5, d.getValor());
            stmt.setFloat(6, d.getMulta());
            stmt.setString(7, d.getNf());

            //executa
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<DevolucaoBEAN> listarALL() {
        String sql = "select * from devolucao;";
        ArrayList<DevolucaoBEAN> devolucaoAL = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);

            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                DevolucaoBEAN d = new DevolucaoBEAN();
                d.setCod(rs.getInt(1));
                d.setDev_funCodigo(rs.getInt(2));
                d.setDev_loCodigo(rs.getInt(3));
                d.setDev_cliCodigo(rs.getInt(4));
                d.setDataDev(rs.getDate(5));
                d.setValor(rs.getFloat(6));
                d.setMulta(rs.getFloat(7));
                d.setNf(rs.getString(8));
                //adiciona os dados no array
                devolucaoAL.add(d);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return devolucaoAL;
    }

    public DevolucaoBEAN localizar(String codigo) {
        String sql = "select * from devolucao where devCodigo = ?;";
        DevolucaoBEAN d = new DevolucaoBEAN();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigo);

            //executa
            ResultSet rs = stmt.executeQuery();

            //joga resultado da consulta no arrayList
            while (rs.next()) {
                d.setCod(rs.getInt(1));
                d.setDev_funCodigo(rs.getInt(2));
                d.setDev_loCodigo(rs.getInt(3));
                d.setDev_cliCodigo(rs.getInt(4));
                d.setDataDev(rs.getDate(5));
                d.setValor(rs.getFloat(6));
                d.setMulta(rs.getFloat(7));
                d.setNf(rs.getString(8));
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return d;
    }

    public boolean editar(DevolucaoBEAN d) {
        String sql = "update devolucao set devCodigo = ?,dev_Nome = ?,dev_Valor = ?;";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setInt(1, d.getCod());
            stmt.setInt(2, d.getDev_funCodigo());
            stmt.setInt(3, d.getDev_loCodigo());
            stmt.setInt(4, d.getDev_cliCodigo());
            stmt.setDate(5, d.getDataDev());
            stmt.setFloat(6, d.getValor());
            stmt.setFloat(7, d.getMulta());
            stmt.setString(8, d.getNf());

            //executa
            int linhasAtualizadas = stmt.executeUpdate();
            stmt.close();
            if (linhasAtualizadas > 0) {
                System.out.println("Foram alterados " + linhasAtualizadas + " resgistros");
            }
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean remover(int codigo) {
        String sql = "delete from devolucao where devCodigo = ?";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setInt(1, codigo);

            //executa
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    public ArrayList<DevolucaoBEAN> listarProduto() {
    String sql = "select dev_Nome from devolucao;";
        ArrayList<DevolucaoBEAN> proAL = new ArrayList<DevolucaoBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                
                DevolucaoBEAN d = new DevolucaoBEAN();
                
               // c.setCod(rs.getInt(1));//indica que o cod ta no campo 1 do rs
                d.setNome(rs.getString(2));
               
                //adiciona os dados no ArrayLIst
                proAL.add(d);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return proAL;
    }  */
}

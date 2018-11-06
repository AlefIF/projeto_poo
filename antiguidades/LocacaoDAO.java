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
public class LocacaoDAO {
    //armazena o obj de conexão com o BD mySql

    private Connection connection;
    //obj stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public LocacaoDAO() {
        //inicializa a conexão com o BD
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(LocacaoBEAN l) {
        String sql = "insert into locacao (loDataAluguel,loPrecoPratico,loc_cliCodigo,loc_funCodigo,loc_joCodigo) " + "values (?,?,?,?,?)";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setDate(1, l.getData());
            stmt.setFloat(2, l.getValor());
            stmt.setInt(3, l.getLoc_cliCodigo());
            stmt.setInt(4, l.getLoc_funCodigo());
            stmt.setInt(5, l.getLoc_jogCodigo());

            //executa
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<LocacaoBEAN> listarALL() throws SQLException {
        String sql = "select * from locacao;";
        ArrayList<LocacaoBEAN> locacaoAL = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);

            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                LocacaoBEAN l = new LocacaoBEAN();
                l.setCod(rs.getInt(1));
                l.setValor(rs.getFloat(3));
                l.setData(rs.getDate(2));
                l.setLoc_cliCodigo(rs.getInt(4));
                l.setLoc_funCodigo(rs.getInt(5));
                l.setLoc_jogCodigo(rs.getInt(6));

                //adiciona os dados no array
                locacaoAL.add(l);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locacaoAL;
    }

    public LocacaoBEAN localizar(String codigo) {
        String sql = "select * from locacao where loCodigo = ?;";
        LocacaoBEAN l = new LocacaoBEAN();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigo);

            //executa
            ResultSet rs = stmt.executeQuery();

            //joga resultado da consulta no arrayList
            while (rs.next()) {
                l.setCod(rs.getInt(1));
                l.setValor(rs.getFloat(3));
                l.setData(rs.getDate(2));
                l.setLoc_cliCodigo(rs.getInt(4));
                l.setLoc_funCodigo(rs.getInt(5));
                l.setLoc_jogCodigo(rs.getInt(6));

            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    public boolean editar(LocacaoBEAN l) {
        String sql = "update locacao set loCodigo = ?,loNome = ?,loValor = ?,loDataAluguel = ?;";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setDate(1, l.getData());
            stmt.setFloat(2, l.getValor());
            stmt.setInt(3, l.getLoc_cliCodigo());
            stmt.setInt(4, l.getLoc_funCodigo());
            stmt.setInt(5, l.getLoc_jogCodigo());

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
        String sql = "delete from locacao where loCodigo = ?";

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

    /*public ArrayList<LocacaoBEAN> listarLocacao() {
    String sql = "select loNome from locacao;";
        ArrayList<LocacaoBEAN> loAL = new ArrayList<LocacaoBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                
                LocacaoBEAN l = new LocacaoBEAN();
                
               // c.setCod(rs.getInt(1));//indica que o cod ta no campo 1 do rs
                l.setCod(rs.getInt(1));
                l.setValor(rs.getFloat(3));
                l.setData(rs.getDate(2));
                l.setLoc_cliCodigo(rs.getInt(4));
                l.setLoc_funCodigo(rs.getInt(5));
                l.setLoc_jogCodigo(rs.getInt(6));
               
                //adiciona os dados no ArrayLIst
                loAL.add(l);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loAL;
    }  
     */
    public ArrayList<LocacaoBEAN> localizarCLi(int cod) {
        String sql = "select * from locacao where loc_cliCodigo = ?;";
        ArrayList<LocacaoBEAN> locacaoAL = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cod);
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                LocacaoBEAN l = new LocacaoBEAN();
                l.setCod(rs.getInt(1));
                l.setValor(rs.getFloat(3));
                l.setData(rs.getDate(2));
                l.setLoc_cliCodigo(rs.getInt(4));
                l.setLoc_funCodigo(rs.getInt(5));
                l.setLoc_jogCodigo(rs.getInt(6));

                //adiciona os dados no array
                locacaoAL.add(l);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locacaoAL;
    }
}

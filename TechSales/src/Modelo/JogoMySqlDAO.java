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

public class JogoMySqlDAO {

    //armazernar meu objeto de conexao com o BD MySQL    
    private Connection connection;
    //objeto stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public JogoMySqlDAO() {
        //inicializa a conexão com o BD - chamando o FActory e Singleton
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(JogoBEAN c) {

        String sql = "insert into jogo (joNome, joFaixaEtaria, joPrecoPadrao, joTipo, joQtd, joLote, jo_catCodigo) values (?,?,?,?,?,?,?);";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, c.getJoNome());
            stmt.setString(2, c.getJoFaixaEtaria());
            stmt.setDouble(3, c.getJoPrecoPadrao());
            stmt.setString(4, c.getJoTipo());
            stmt.setInt(5, c.getJoQtd());
            stmt.setString(6, c.getJoLote());
            stmt.setInt(7, c.getJo_catCodigo());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<JogoBEAN> listarALL() {
        String sql = "select *from jogo;";
        ArrayList<JogoBEAN> jogoAL = new ArrayList<JogoBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                JogoBEAN c = new JogoBEAN();
                c.setJoCodigo(rs.getInt("joCodigo"));//indica que o cod ta no campo 1 do rs
                c.setJoNome(rs.getString(2));
                c.setJoFaixaEtaria(rs.getString(3));
                c.setJoPrecoPadrao(rs.getDouble(4));
                c.setJoTipo(rs.getString(5));
                c.setJoQtd(rs.getInt(6));
                c.setJoLote(rs.getString(7));
                c.setJo_catCodigo(rs.getInt(8));
                //adiciona os dados no ArrayLIst
                jogoAL.add(c);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jogoAL;
    }

    public boolean editar(JogoBEAN c) {

        String sql = "update jogo set joNome = ?,joFaixaEtaria = ?,"
                + " joPrecoPadrao=?, joTipo = ?, joQtd = ?, joLote = ?, jo_catCodigo = ?  where joCodigo = ?;";
        try {
            /* metodo usado para criar um objeto que representa a instrução 
            SQL que será executada, sendo que é invocado através do objeto 
            Connection.
            
            Deve ser colocado dentro de um bloco try catch */
            stmt = connection.prepareStatement(sql);
            // seta os valores

            stmt.setString(1, c.getJoNome());
            stmt.setString(2, c.getJoFaixaEtaria());
            stmt.setDouble(3, c.getJoPrecoPadrao());
            stmt.setString(4, c.getJoTipo());
            stmt.setInt(5, c.getJoQtd());
            stmt.setString(6, c.getJoLote());
            stmt.setInt(7, c.getJo_catCodigo());
            stmt.setInt(8, c.getJoCodigo());

            // executa update
            int linhasAtualizadas = stmt.executeUpdate();
            stmt.close();
            //apenas se quiser saber quantas linhas foram alteradas
            if (linhasAtualizadas > 0) {
                System.out.println("Foram alterados " + linhasAtualizadas + " registros");
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean remover(int codigo) {
        String sql = "delete from jogo where joCodigo = ?";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, codigo);
            // executa
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

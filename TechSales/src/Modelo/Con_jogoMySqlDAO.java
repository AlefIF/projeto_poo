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
 * @author admin
 */
public class Con_jogoMySqlDAO {

    //armazernar meu objeto de conexao com o BD MySQL    
    private Connection connection;
    //objeto stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public Con_jogoMySqlDAO() {
        //inicializa a conexão com o BD - chamando o FActory e Singleton
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrar2(Con_jogoBEAN w) {

        String sql = "insert into con_jogo (cjg_conCodigo) values (?);";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, w.getCjg_conCodigo());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean editar2(Con_jogoBEAN w) {
        String sql = "update  con_jogo set cjg_conCodigo=? where cjg_joCodigo = ?;";

        try {
            /* metodo usado para criar um objeto que representa a instrução 
            SQL que será executada, sendo que é invocado através do objeto 
            Connection.
            
            Deve ser colocado dentro de um bloco try catch */
            stmt = connection.prepareStatement(sql);
            // seta os valores   
            stmt.setInt(2, w.getCjg_joCodigo());
            stmt.setInt(1, w.getCjg_conCodigo());

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

    public boolean remover2(int codigo) {
        String sql = "delete from con_jogo where cjg_joCodigo = ?";
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

    public ArrayList<Con_jogoBEAN> listarALL() {
        String sql = "select *from con_jogo;";
        ArrayList<Con_jogoBEAN> cjAL = new ArrayList<Con_jogoBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                Con_jogoBEAN b = new Con_jogoBEAN();
                b.setCjg_joCodigo(rs.getInt(1));
                b.setCjg_conCodigo(rs.getInt(2));//indica que o cod ta no campo 1 do rs

                //adiciona os dados no ArrayLIst
                cjAL.add(b);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cjAL;
    }

}
